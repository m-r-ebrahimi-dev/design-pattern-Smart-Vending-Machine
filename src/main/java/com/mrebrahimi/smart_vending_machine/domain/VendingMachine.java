package com.mrebrahimi.smart_vending_machine.domain;

import com.mrebrahimi.smart_vending_machine.state.MachineState;
import com.mrebrahimi.smart_vending_machine.state.MachineStateFactory;
import com.mrebrahimi.smart_vending_machine.state.VendingMachineStateListener;
import jakarta.persistence.*;

@Entity
@Table(name = "VENDING_MACHINES")
@EntityListeners(VendingMachineStateListener.class)
public class VendingMachine {
    @Id
    @Column(name = "MACHINE_ID")
    private String machineId;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ITEM_COUNT")
    private int itemCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENT_STATE", nullable = false)
    private MachineStateName stateName = MachineStateName.NO_COIN;

    @Transient
    private MachineState currentState;

    public void insertCoin() {
        this.currentState.insertCoin(this);
    }

    public void ejectCoin() {
        this.currentState.ejectCoin(this);
    }

    public void selectItem() {
        this.currentState.selectItem(this);
        this.currentState.dispense(this);
    }

    public void releaseItem() {
        if (this.itemCount > 0) {
            this.itemCount--;
            System.out.println("An item was released.");
        }
    }

    public void refill(int count) {
        this.itemCount += count;
        System.out.println(count + " items added. Total: " + this.itemCount);
        if (getStateName() == MachineStateName.SOLD_OUT && this.itemCount > 0) {
            changeState(MachineStateFactory.getState(MachineStateName.NO_COIN));
        }
    }

    public void changeState(MachineState newState) {
        this.currentState = newState;
        this.stateName = newState.getStateName();
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public MachineStateName getStateName() {
        return stateName;
    }

    public void setStateName(MachineStateName stateName) {
        this.stateName = stateName;
    }
}