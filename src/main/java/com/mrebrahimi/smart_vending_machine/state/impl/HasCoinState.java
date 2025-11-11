package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("HAS_COIN")
public class HasCoinState extends BaseMachineState {
    private final Random randomWinner = new Random();

    @Override
    public void ejectCoin(VendingMachine machine) {
        System.out.println("STATE: HAS_COIN -> NO_COIN. Coin ejected.");
        machine.changeState(MachineStateFactory.getState(MachineStateName.NO_COIN));
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("STATE: HAS_COIN -> ???. Item selected.");
        boolean isWinner = randomWinner.nextInt(10) == 0 && machine.getItemCount() > 1;
        if (isWinner) {
            System.out.println(">> It's a WINNER! Transitioning to WINNER state.");
            machine.changeState(MachineStateFactory.getState(MachineStateName.WINNER));
        } else {
            System.out.println(">> Normal sale. Transitioning to SOLD state.");
            machine.changeState(MachineStateFactory.getState(MachineStateName.SOLD));
        }
    }
    @Override
    public MachineStateName getStateName() {
        return MachineStateName.HAS_COIN;
    }
}
