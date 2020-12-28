package ninfox.oversized.trash.tokyo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * メール処理
 * @author Komatsubara Takeshi
 *
 */
@Slf4j
@AllArgsConstructor
@Repository
public class MailRepository {

    private final Folder folder;

    /**
     * 件名でフィルターしたメール一覧を取得する
     * @param subject 件名
     * @param number 最新メールから何件前までのメールを検索対象にするかの設定
     * @return
     * @throws MessagingException
     */
    public List<Message> filteredSubjectMails(@NotBlank String subject, @Min(1) int number)
            throws MessagingException {

        folder.open(Folder.READ_ONLY);

        int messageCount = folder.getMessageCount();
        int searchStartIndex = this.validSearchStartIndex(number, messageCount);

        Message[] latestMessages = folder.getMessages(searchStartIndex, messageCount);

        FetchProfile fetchProfile = new FetchProfile();
        fetchProfile.add(FetchProfile.Item.ENVELOPE);
        folder.fetch(latestMessages, fetchProfile);

        return Arrays.stream(latestMessages).filter(message -> {
            try {
                return StringUtils.contains(message.getSubject(), subject);
            } catch (MessagingException e) {
                log.warn(e.getMessage());
                return false;
            }
        }).collect(Collectors.toList());
    }

    /**
     * 件名でフィルターしたメール一覧から最新日時のメールを取得する
     * @param subject 件名
     * @param number 最新メールから何件前までのメールを検索対象にするかの設定
     * @return
     * @throws MessagingException
     */
    public Message getFilteredLatestMessage(@NotBlank String subject, @Min(1) int number) throws MessagingException {
        List<Message> messages = filteredSubjectMails(subject, number);
        return messages.get(messages.size() - 1);
    }

    /**
     * 検索件数範囲の入力チェック
     * @param number 最新メールから何件前までのメールを検索対象にするかの設定
     * @param messageCount メールボックスのメッセージ総数
     * @return
     */
    public int validSearchStartIndex(int number, int messageCount) {

        int searchStartIndex = messageCount - number;
        if (searchStartIndex < 1) {
            searchStartIndex = messageCount - 1;
            log.info(
                    "getMessages() start value is illegal!! It is must > 0. So, It is setted to {}.  messageCount = {}",
                    searchStartIndex, messageCount);
        }
        return searchStartIndex;
    }
}
