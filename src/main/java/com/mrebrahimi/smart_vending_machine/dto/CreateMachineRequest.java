package com.mrebrahimi.smart_vending_machine.dto;


public record CreateMachineRequest(String machineId, String location, int initialStock) {
}
