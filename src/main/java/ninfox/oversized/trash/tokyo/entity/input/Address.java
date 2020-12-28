package ninfox.oversized.trash.tokyo.entity.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {

    /**
     * 排出区の名称
     */
    private String ward;

    /**
     * 郵便番号
     */
    private String zip;

    /**
     * 字
     */
    private String aza;

    /**
     * 丁目
     */
    private String choume;

    /**
     * 番
     */
    private String ban;

    /**
     * 号
     */
    private String gou;

    /**
     * 建物名
     */
    private String building;

    /**
     * 部屋番号
     */
    private String roomNumber;
}
