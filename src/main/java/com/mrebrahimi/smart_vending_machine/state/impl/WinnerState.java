package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

@Component("WINNER")
public class WinnerState extends BaseMachineState {
    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("YOU'RE A WINNER! You get two items for your coin!");
        machine.releaseItem();
        machine.releaseItem();

        if (machine.getItemCount() > 0) {
            machine.changeState(MachineStateFactory.getState(MachineStateName.NO_COIN));
        } else {
            System.out.println("Oops, out of stock!");
            machine.changeState(MachineStateFactory.getState(MachineStateName.SOLD_OUT));
        }
    }

    @Override
    public MachineStateName getStateName() {
        return MachineStateName.WINNER;
    }
}