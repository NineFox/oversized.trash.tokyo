package ninfox.oversized.trash.tokyo.entity.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

import lombok.Getter;

/**
 * メールアドレス登録
 * @author Komatsubara Takeshi
 *
 */
@Getter
public class RegisterMailAddressPage {

    /**
     * メールアドレス
     */
    @FindBy(id = "txtMail")
    private SelenideElement mail;

    /**
     * メールアドレス(確認用)
     */
    @FindBy(id = "txtMail2")
    private SelenideElement confileMail;

    /**
     * 同意チェック
     */
    @FindBy(id = "chkAuth")
    private SelenideElement checkAuth;

    /**
     * メールアドレス登録
     */
    @FindBy(className = "btn")
    private SelenideElement registerMail;

    /**
     * メールアドレス登録処理
     * @param mailAddress
     */
    public void registerMail(String mailAddress) {
        mail.setValue(mailAddress);
        confileMail.setValue(mailAddress);
        checkAuth.isSelected();
        registerMail.click();
    }
}
