package ninfox.oversized.trash.tokyo.entity.page;

import javax.validation.constraints.NotNull;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

import lombok.Getter;
import ninfox.oversized.trash.tokyo.entity.input.DischargeInformationProperties;

/**
 * 排出者情報入力
 * @author Komatsubara Takeshi
 *
 */
@Getter
public class TrashInformationPage {

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

    /**
     * 住所を自動検索
     */
    @FindBy(name = "cmdZip")
    private SelenideElement searchAddress;

    /**
     * 排出者情報の入力
     * @param dischargeInformationProperties
     */
    public void inputInformation(@NotNull DischargeInformationProperties dischargeInformationProperties) {
        phone.setValue(dischargeInformationProperties.getPhone());
        name.setValue(dischargeInformationProperties.getName());
        zip.setValue(dischargeInformationProperties.getAddress().getZip());

        searchAddress.click();

        choume.selectOptionContainingText(dischargeInformationProperties.getAddress().getAza());
        ban.setValue(dischargeInformationProperties.getAddress().getBan());
        gou.setValue(dischargeInformationProperties.getAddress().getGou());
        building.setValue(dischargeInformationProperties.getAddress().getBuilding());
        roomNumber.setValue(dischargeInformationProperties.getAddress().getRoomNumber());
        trashSpace.selectOptionContainingText(dischargeInformationProperties.getTrashSpace());
    }
}
