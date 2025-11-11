package com.mrebrahimi.smart_vending_machine.state;


import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import jakarta.persistence.PostLoad;
import org.springframework.stereotype.Component;

@Component
public class VendingMachineStateListener {
    @PostLoad
    public void mapState(VendingMachine machine) {
        machine.setCurrentState(MachineStateFactory.getState(machine.getStateName()));
    }
}