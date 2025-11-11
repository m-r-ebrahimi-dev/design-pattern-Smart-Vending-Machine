package com.mrebrahimi.smart_vending_machine.state.common;

import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.exception.InvalidActionException;
import com.mrebrahimi.smart_vending_machine.state.MachineState;

public abstract class BaseMachineState implements MachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        throw new InvalidActionException("insertCoin", getStateName());
    }

    @Override
    public void ejectCoin(VendingMachine machine) {
        throw new InvalidActionException("ejectCoin", getStateName());
    }

    @Override
    public void selectItem(VendingMachine machine) {
        throw new InvalidActionException("selectItem", getStateName());
    }

    @Override
    public void dispense(VendingMachine machine) {
        throw new InvalidActionException("dispense", getStateName());
    }

    @Override
    public void refill(VendingMachine machine, int count) {
        machine.setItemCount(machine.getItemCount() + count);
        System.out.println("Refilled " + count + " items. Total: " + machine.getItemCount());
    }
}