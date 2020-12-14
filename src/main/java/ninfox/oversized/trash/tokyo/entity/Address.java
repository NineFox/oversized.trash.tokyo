package ninfox.oversized.trash.tokyo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {
    /**
     * 郵便番号
     */
    private String zip;

    /**
     * 町名
     */
    private String choume;

    /**
     * 番地
     */
    private String houseNumber;

    /**
     * 建物名
     */
    private String building;

    /**
     * 部屋番号
     */
    private String roomNumber;
}
