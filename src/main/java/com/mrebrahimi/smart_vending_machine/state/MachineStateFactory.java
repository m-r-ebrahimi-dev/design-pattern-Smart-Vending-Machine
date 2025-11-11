package com.mrebrahimi.smart_vending_machine.state;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MachineStateFactory {
    private static ApplicationContext context;

    public MachineStateFactory(ApplicationContext context) {
        MachineStateFactory.context = context;
    }

    public static MachineState getState(MachineStateName stateName) {
        return context.getBean(stateName.name(), MachineState.class);
    }
}
