package com.mrebrahimi.smart_vending_machine.repository;

import com.mrebrahimi.smart_vending_machine.domain.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineRepository extends JpaRepository<VendingMachine, String> {
}
