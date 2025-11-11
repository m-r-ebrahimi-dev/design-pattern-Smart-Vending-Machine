package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

@Component("NO_COIN")
public class NoCoinState extends BaseMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("You inserted a coin.");
        machine.changeState(MachineStateFactory.getState(MachineStateName.HAS_COIN));
    }

    @Override
    public MachineStateName getStateName() {
        return MachineStateName.NO_COIN;
    }
}
