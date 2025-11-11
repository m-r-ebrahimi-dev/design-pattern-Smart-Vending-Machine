package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("HAS_COIN")
public class HasCoinState extends BaseMachineState {
    private final Random randomWinner = new Random(System.currentTimeMillis());

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("You can't insert another coin.");
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        System.out.println("Coin returned.");
        machine.changeState(MachineStateFactory.getState(MachineStateName.NO_COIN));
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("You selected an item...");
        boolean isWinner = randomWinner.nextInt(10) == 0;
        if (isWinner && machine.getItemCount() > 1) {
            machine.changeState(MachineStateFactory.getState(MachineStateName.WINNER));
        } else {
            machine.changeState(MachineStateFactory.getState(MachineStateName.SOLD));
        }
    }

    @Override
    public MachineStateName getStateName() {
        return MachineStateName.HAS_COIN;
    }
}
