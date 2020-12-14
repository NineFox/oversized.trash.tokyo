package ninfox.oversized.trash.tokyo.command;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import ninfox.oversized.trash.tokyo.service.InfInputService;
import picocli.CommandLine.Command;

@AllArgsConstructor
@Component
@Command(name = "inputCommand")
public class InputCommand implements Callable<Integer> {

    private InfInputService inputService;

    @Override
    public Integer call() throws Exception {
        inputService.inputMessage();
        return 0;
    }

}
