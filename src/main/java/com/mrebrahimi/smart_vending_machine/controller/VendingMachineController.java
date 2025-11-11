package com.mrebrahimi.smart_vending_machine.controller;

import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import com.mrebrahimi.smart_vending_machine.dto.CreateMachineRequest;
import com.mrebrahimi.smart_vending_machine.service.VendingMachineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machines")
public class VendingMachineController {
    private final VendingMachineService service;

    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @PostMapping
    public VendingMachine createMachine(@RequestBody CreateMachineRequest request) {
        return service.createMachine(request.machineId(), request.location(), request.initialStock());
    }

    @GetMapping("/{id}")
    public VendingMachine getMachine(@PathVariable String id) {
        return service.getMachineStatus(id);
    }

    @PostMapping("/{id}/coin")
    public void insertCoin(@PathVariable String id) {
        service.insertCoin(id);
    }

    @DeleteMapping("/{id}/coin")
    public void ejectCoin(@PathVariable String id) {
        service.ejectCoin(id);
    }

    @PostMapping("/{id}/select")
    public void selectItem(@PathVariable String id) {
        service.selectItem(id);
    }

    @PostMapping("/{id}/refill")
    public void refill(@PathVariable String id, @RequestParam int count) {
        service.refillMachine(id, count);
    }
}
