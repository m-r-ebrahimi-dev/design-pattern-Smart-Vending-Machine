package com.mrebrahimi.smart_vending_machine.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "VENDING_MACHINES")
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