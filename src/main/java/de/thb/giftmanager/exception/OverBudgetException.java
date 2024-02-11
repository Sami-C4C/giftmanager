package de.thb.giftmanager.exception;

public class OverBudgetException extends RuntimeException{

    public OverBudgetException( String message){
        super(message);
    }
}
