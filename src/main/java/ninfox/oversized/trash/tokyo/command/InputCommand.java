package ninfox.oversized.trash.tokyo.command;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import ninfox.oversized.trash.tokyo.service.InfInputService;
import ninfox.oversized.trash.tokyo.service.MailService;
import picocli.CommandLine.Command;

@AllArgsConstructor
@Component
@Command(name = "inputCommand")
public class InputCommand implements Callable<Integer> {

    private InfInputService inputService;

    private MailService mailService;

    @Override
    public Integer call() throws Exception {
        //inputService.inputMessage();
        mailService.readMessage();
        return 0;
    }

}
