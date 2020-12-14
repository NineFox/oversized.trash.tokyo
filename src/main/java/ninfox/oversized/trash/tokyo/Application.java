package ninfox.oversized.trash.tokyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import lombok.Getter;
import ninfox.oversized.trash.tokyo.command.InputCommand;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private IFactory factory;
    private InputCommand inputCommand;

    @Getter
    private int exitCode = 0;

    Application(IFactory factory, InputCommand inputCommand) {
        this.factory = factory;
        this.inputCommand = inputCommand;
    }

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(inputCommand, factory).execute(args);
    }

    public static void main(String args[]) {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }

}
