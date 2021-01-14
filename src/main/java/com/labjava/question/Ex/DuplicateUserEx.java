package com.labjava.question.Ex;

public class DuplicateUserEx extends RuntimeException {
    public DuplicateUserEx(){
        super("Exista deja un cont cu aceasta adresa de email!");
    }
}
