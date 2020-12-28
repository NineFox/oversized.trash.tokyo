package ninfox.oversized.trash.tokyo.service;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codeborne.selenide.Selenide;

import lombok.extern.slf4j.Slf4j;
import ninfox.oversized.trash.tokyo.entity.input.DischargeInformationProperties;
import ninfox.oversized.trash.tokyo.entity.page.RegisterMailAddressPage;
import ninfox.oversized.trash.tokyo.entity.page.RequestAttentionPage;
import ninfox.oversized.trash.tokyo.entity.page.TrashInformationPage;
import ninfox.oversized.trash.tokyo.entity.page.TrashTopPage;
import ninfox.oversized.trash.tokyo.repository.MailRepository;

@Slf4j
@Service
public class InputService {

    /**
     * 粗大ごみ受付メールの件名
     */
    @Value("${mail.subject}")
    private String subjectOversizedTrashReception;

    /**
     * メールの検索件数
     */
    @Value("${mail.numberSearches}")
    private int numberSearches;

    /**
     * 粗大ごみ受付メールに記述されているURLの正規表現
     */
    private final Pattern authEncKeyURLRegex = Pattern.compile("https://sodai.tokyokankyo.or.jp/Sodai/V2AuthEncKey/*");

    private MailRepository mailRepository;

    public InputService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public void inputMessage(URL trashTopPageURL, String mailAddress,
            DischargeInformationProperties dischargeInformationProperties) throws MessagingException, IOException {

        log.info(dischargeInformationProperties.toString());

        URL dischargerInformationURL = preInput(trashTopPageURL, mailAddress, dischargeInformationProperties);

        inputDischargerInformation(dischargerInformationURL, dischargeInformationProperties);
    }

    private URL preInput(URL trashTopPageURL, String mailAddress,
            DischargeInformationProperties dischargeInformationProperties) throws MessagingException, IOException {

        TrashTopPage trashTopPage = Selenide.open(trashTopPageURL, TrashTopPage.class);
        RequestAttentionPage requestAttentionPage = trashTopPage
                .clickWard(dischargeInformationProperties.getAddress().getWard());
        RegisterMailAddressPage registerMailAddressPage = requestAttentionPage.sendRequest();
        registerMailAddressPage.registerMail(mailAddress);
        Message oversizedTrashReceptionMessage = mailRepository.getFilteredLatestMessage(subjectOversizedTrashReception,
                numberSearches);
        String oversizedTrashReceptionContent = oversizedTrashReceptionMessage.getContent().toString();

        return new URL(authEncKeyURLRegex.matcher(oversizedTrashReceptionContent).group());
    }

    private void inputDischargerInformation(URL dischargerInformationURL,
            DischargeInformationProperties dischargeInformationProperties) {
        TrashInformationPage dischargerInformationPage = Selenide
                .open(dischargerInformationURL, TrashInformationPage.class);

        dischargerInformationPage.inputInformation(dischargeInformationProperties);
    }

}
