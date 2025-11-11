package com.mrebrahimi.smart_vending_machine.domain;

import com.mrebrahimi.smart_vending_machine.state.MachineState;
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

    public VendingMachine() {
    }

    public VendingMachine(String machineId, String location, int initialStock) {
        this.machineId = machineId;
        this.location = location;
        this.itemCount = initialStock;
    }

    public void insertCoin() {
        System.out.println("ACTION: insertCoin called.");
        this.currentState.insertCoin(this);
    }

    public void ejectCoin() {
        System.out.println("ACTION: ejectCoin called.");
        this.currentState.ejectCoin(this);
    }

    public void selectItem() {
        System.out.println("ACTION: selectItem called.");
        this.currentState.selectItem(this); // Transitions to SOLD or WINNER
        this.currentState.dispense(this);   // The new state dispenses
    }

    public void refill(int count) {
        System.out.println("ACTION: refill called with " + count + " items.");
        this.currentState.refill(this, count);
    }

    public void releaseItem() {
        if (this.itemCount > 0) {
            this.itemCount--;
            System.out.println(">> Internal: Item released. Stock is now: " + this.itemCount);
        } else {
            System.out.println(">> Internal: Attempted to release item but stock is zero!");
        }
    }

    public void changeState(MachineState newState) {
        System.out.println(">> State Changed from " + this.stateName + " to " + newState.getStateName());
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