package ninfox.oversized.trash.tokyo.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ninfox.oversized.trash.tokyo.entity.input.DischargeInformationProperties;
import ninfox.oversized.trash.tokyo.entity.page.DischargerInformationPage;

@Slf4j
@AllArgsConstructor
@Service
public class InputService implements InfInputService {

    private DischargeInformationProperties dischargeInfoProp;

    @Override
    public void inputMessage() {

        log.info(dischargeInfoProp.toString());

        DischargerInformationPage dischargerInformationPage = null; //Selenide.open("", DischargerInformationPage.class);

        dischargerInformationPage.getPhone().setValue(dischargeInfoProp.getPhone());
        dischargerInformationPage.getName().setValue(dischargeInfoProp.getName());
        dischargerInformationPage.getZip().setValue(dischargeInfoProp.getAddress().getZip());

        dischargerInformationPage.getSearchAddress().click();

        dischargerInformationPage.getChoume().selectOptionContainingText(dischargeInfoProp.getAddress().getAza());
        dischargerInformationPage.getBan().setValue(dischargeInfoProp.getAddress().getBan());
        dischargerInformationPage.getGou().setValue(dischargeInfoProp.getAddress().getGou());
        dischargerInformationPage.getBuilding().setValue(dischargeInfoProp.getAddress().getBuilding());
        dischargerInformationPage.getRoomNumber().setValue(dischargeInfoProp.getAddress().getRoomNumber());
        dischargerInformationPage.getTrashSpace().selectOptionContainingText(dischargeInfoProp.getTrashSpace());
    }

}
