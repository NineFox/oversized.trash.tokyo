package ninfox.oversized.trash.tokyo.entity.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

import lombok.Getter;

/**
 * 排出者情報入力
 * @author Komatsubara Takeshi
 *
 */
@Getter
public class DischargerInformationPage {

    /**
     * 電話番号
     */
    @FindBy(id = "tel")
    private SelenideElement phone;

    /**
     * メール
     */
    @FindBy(id = "txtMail")
    private SelenideElement mail;

    /**
     * メール(確認用)
     */
    @FindBy(id = "txtMail2")
    private SelenideElement confilmMail;

    /**
     * 名前
     */
    @FindBy(id = "txtName")
    private SelenideElement name;

    /**
     * 名前(よみがな)
     */
    @FindBy(id = "txtKana")
    private SelenideElement yomikanaName;

    /**
     * 郵便番号
     */
    @FindBy(id = "txtZip")
    private SelenideElement zip;

    /**
     * 丁目(住所)
     */
    @FindBy(id = "lstChoume")
    private SelenideElement choume;

    /**
     * 番地(住所)
     */
    @FindBy(id = "txtBan")
    private SelenideElement ban;

    /**
     * 号(住所)
     */
    @FindBy(id = "txtGo")
    private SelenideElement gou;

    /**
     * 建物名(住所)
     */
    @FindBy(id = "building")
    private SelenideElement building;

    /**
     * 部屋番号(住所)
     */
    @FindBy(id = "txtRoom")
    private SelenideElement roomNumber;

    /**
     * 排出場所
     */
    @FindBy(id = "lstOutPlace")
    private SelenideElement trashSpace;

}
