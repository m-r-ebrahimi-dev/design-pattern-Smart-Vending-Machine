package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

@Component("SOLD_OUT")
public class SoldOutState extends BaseMachineState {
    @Override
    public void refill(VendingMachine machine, int count) {
        System.out.println("STATE: SOLD_OUT -> NO_COIN. Refilling machine.");
        super.refill(machine, count);
        if (machine.getItemCount() > 0) {
            machine.changeState(MachineStateFactory.getState(MachineStateName.NO_COIN));
        }
    }

    @Override
    public MachineStateName getStateName() {
        return MachineStateName.SOLD_OUT;
    }
}