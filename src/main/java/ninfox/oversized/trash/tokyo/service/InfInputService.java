package ninfox.oversized.trash.tokyo.service;

import java.net.URL;

import ninfox.oversized.trash.tokyo.entity.input.DischargeInformationProperties;

public interface InfInputService {
    void inputMessage(URL trashTopPage, DischargeInformationProperties dischargeInfoProp);
}
