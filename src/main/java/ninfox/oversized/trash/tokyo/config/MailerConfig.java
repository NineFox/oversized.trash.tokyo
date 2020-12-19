package ninfox.oversized.trash.tokyo.config;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class MailerConfig {

    @Value("${mail.imap.server}")
    private String imapServer;

    @Value("${mail.imap.port}")
    private Integer imapPort;

    @Value("${mail.login.user}")
    private String user;

    @Value("${mail.login.password}")
    private String password;

    @Bean
    public Folder getMailFolder() throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.imaps.ssl.trust", imapServer);

        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");
        store.connect(imapServer, imapPort, user, password);
        return store.getFolder("INBOX");
    }
}
