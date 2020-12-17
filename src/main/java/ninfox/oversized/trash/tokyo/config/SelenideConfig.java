package ninfox.oversized.trash.tokyo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import lombok.Getter;

/**
 * Selenide の設定
 * @author Komatsubara Takeshi
 *
 */
@Component
public class SelenideConfig {

    @Getter
    @Value("${url.page.top}")
    private String baseURL;

    /**
     * Selenide の初期設定
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initSelenideConfig() {
        Configuration.browser = WebDriverRunner.FIREFOX;
        // BaseURLを設定する
        Configuration.baseUrl = baseURL;
    }
}
