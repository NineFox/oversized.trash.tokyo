package ninfox.oversized.trash.tokyo.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ninfox.oversized.trash.tokyo.entity.DischargeInfomationProperties;

@Slf4j
@AllArgsConstructor
@Service
public class InputService implements InfInputService {

    private DischargeInfomationProperties dischargeInfomationProperties;

    @Override
    public void inputMessage() {
        log.info(dischargeInfomationProperties.getName());
        log.info(dischargeInfomationProperties.getAddress().getBuilding());
    }

}
