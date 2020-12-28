package ninfox.oversized.trash.tokyo.command;

import java.util.concurrent.Callable;

import javax.mail.Message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ninfox.oversized.trash.tokyo.repository.MailRepository;
import ninfox.oversized.trash.tokyo.service.InfInputService;
import picocli.CommandLine.Command;

@Slf4j
@Component
@Command(name = "inputCommand")
public class InputCommand implements Callable<Integer> {

    private InfInputService inputService;

    private MailRepository mailService;

    /**
     * 検索範囲のメール件数
     */
    @Value("${mail.latestNumber}")
    private Integer latestNumber;

    /**
     * 検索対象のメール件名
     */
    @Value("${mail.subject}")
    private String subject;

    public InputCommand(InfInputService inputService, MailRepository mailService) {
        this.inputService = inputService;
        this.mailService = mailService;
    }

    @Override
    public Integer call() throws Exception {
        //inputService.inputMessage();

        Message message = mailService.getFilteredLatestMessage(subject, latestNumber);
        log.debug(message.getReceivedDate() + " " + message.getSubject());

        return 0;
    }

}
