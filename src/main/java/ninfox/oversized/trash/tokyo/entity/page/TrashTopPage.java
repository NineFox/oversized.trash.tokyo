package ninfox.oversized.trash.tokyo.entity.page;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;

/**
 * 粗大ごみ受付トップページ
 * @author Komatsubara Takeshi
 *
 */
public class TrashTopPage {

    /**
     * 排出区の取得
     * @param ward 区名
     * @return
     */
    public RequestAttentionPage clickWard(String ward) {
        $(byAttribute("alt", ward)).click();
        return Selenide.page(RequestAttentionPage.class);
    }

}
