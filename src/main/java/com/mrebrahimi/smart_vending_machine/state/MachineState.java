package com.mrebrahimi.smart_vending_machine.state;


import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;

public interface MachineState {
    void insertCoin(VendingMachine machine);
    void ejectCoin(VendingMachine machine);
    void selectItem(VendingMachine machine);

    void dispense(VendingMachine machine);

    void refill(VendingMachine machine, int count);
    MachineStateName getStateName();
}