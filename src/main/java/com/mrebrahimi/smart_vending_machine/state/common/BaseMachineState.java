package com.mrebrahimi.smart_vending_machine.state.common;

import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.exception.InvalidActionException;
import com.mrebrahimi.smart_vending_machine.state.MachineState;

public abstract class BaseMachineState implements MachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        throw new InvalidActionException("You can't insert a coin now.");
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        throw new InvalidActionException("You can't eject a coin now.");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        throw new InvalidActionException("You can't select an item now.");
    }

    @Override
    public void dispense(VendingMachine machine) {
        throw new InvalidActionException("Cannot dispense at this time.");
    }
}