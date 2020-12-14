package ninfox.oversized.trash.tokyo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "personal-information")
public class DischargeInfomationProperties {

    /**
     * 電話番号
     */
    private String phone;

    /**
     * 名前
     */
    private String name;

    /**
     * 名前(よみがな)
     */
    private String nameYomikana;

    /**
     * 住所
     */
    @NestedConfigurationProperty
    private Address address;

    /**
     * 排出場所
     */
    private String trashSpace;
}
