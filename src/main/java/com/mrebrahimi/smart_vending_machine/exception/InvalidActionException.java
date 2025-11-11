package com.mrebrahimi.smart_vending_machine.exception;

import com.mrebrahimi.smart_vending_machine.domain.MachineStateName;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidActionException extends RuntimeException {
    public InvalidActionException(String action, MachineStateName state) {
        super(String.format("Action '%s' is not allowed when machine is in '%s' state.", action, state));
    }
}