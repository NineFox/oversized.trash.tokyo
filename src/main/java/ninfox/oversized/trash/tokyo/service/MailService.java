package ninfox.oversized.trash.tokyo.service;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class MailService {

    private final Folder folder;

    public void readMessage() throws MessagingException {
        try (folder) {
            folder.open(Folder.READ_ONLY);

            Message[] messages = folder.getMessages(1, 5);

            for (Message message : messages) {
                log.info(message.getReceivedDate().toString());
            }
        }
    }
}
