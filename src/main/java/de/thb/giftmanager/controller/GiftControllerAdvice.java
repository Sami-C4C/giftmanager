package de.thb.giftmanager.controller;

import de.thb.giftmanager.exception.OverBudgetException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GiftControllerAdvice {

    @ResponseBody
    @ExceptionHandler(OverBudgetException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String overBudgetHandler(OverBudgetException exception) {
        return exception.getMessage();
    }
}
