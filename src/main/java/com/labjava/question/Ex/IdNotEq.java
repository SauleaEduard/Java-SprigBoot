package com.labjava.question.Ex;

public class IdNotEq extends RuntimeException {
    public IdNotEq(){
        super("Idul din body nu este acelasi cu cel al parametrului");
    }
}
