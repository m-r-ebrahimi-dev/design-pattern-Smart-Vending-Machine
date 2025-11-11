package com.mrebrahimi.smart_vending_machine.state.impl;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import com.mrebrahimi.smart_vending_machine.state.common.BaseMachineState;
import org.springframework.stereotype.Component;

@Component("SOLD_OUT")
public class SoldOutState extends BaseMachineState {
    @Override
    public MachineStateName getStateName() {
        return MachineStateName.SOLD_OUT;
    }
}