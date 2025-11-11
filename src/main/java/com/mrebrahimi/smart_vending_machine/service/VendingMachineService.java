package com.mrebrahimi.smart_vending_machine.service;

import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.repository.VendingMachineRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendingMachineService {
    private final VendingMachineRepository repository;

    public VendingMachineService(VendingMachineRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public VendingMachine createMachine(String machineId, String location, int initialStock) {
        VendingMachine machine = new VendingMachine(machineId, location, initialStock);
        return repository.save(machine);
    }

    @Transactional
    public void insertCoin(String machineId) {
        findMachineById(machineId).insertCoin();
    }

    @Transactional
    public void ejectCoin(String machineId) {
        findMachineById(machineId).ejectCoin();
    }

    @Transactional
    public void selectItem(String machineId) {
        findMachineById(machineId).selectItem();
    }

    @Transactional(readOnly = true)
    public VendingMachine getMachineStatus(String machineId) {
        return findMachineById(machineId);
    }

    @Transactional
    public void refillMachine(String machineId, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Refill count must be positive.");
        }
        findMachineById(machineId).refill(count);
    }

    private VendingMachine findMachineById(String machineId) {
        return repository.findById(machineId)
                .orElseThrow(() -> new EntityNotFoundException("Machine not found: " + machineId));
    }
}