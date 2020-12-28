package ninfox.oversized.trash.tokyo.entity.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

/**
 * 注意事項ページ
 * @author Komatsubara Takeshi
 *
 */
public class RequestAttentionPage {

    /**
     * リクエスト送信エレメント
     */
    @FindBy(xpath = "//div[@id='main']/div/section/input[@class='btn']")
    private SelenideElement request;

    /**
     * 申し込み送信
     * @return
     */
    public RegisterMailAddressPage sendRequest() {
        request.click();
        return Selenide.page(RegisterMailAddressPage.class);
    }

}
