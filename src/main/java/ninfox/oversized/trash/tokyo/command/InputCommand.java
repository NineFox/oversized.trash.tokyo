package ninfox.oversized.trash.tokyo.command;

import java.util.List;
import java.util.concurrent.Callable;

import javax.mail.Message;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ninfox.oversized.trash.tokyo.service.InfInputService;
import ninfox.oversized.trash.tokyo.service.MailService;
import picocli.CommandLine.Command;

@Slf4j
@AllArgsConstructor
@Component
@Command(name = "inputCommand")
public class InputCommand implements Callable<Integer> {

    private InfInputService inputService;

    private MailService mailService;

    @Override
    public Integer call() throws Exception {
        //inputService.inputMessage();
        List<Message> messages = mailService.filteredSubjectMails("粗大ごみ申込みのご案内", 1500);

        for (Message message : messages) {
            log.debug(message.getReceivedDate() + " " + message.getSubject());
        }

        return 0;
    }

}
