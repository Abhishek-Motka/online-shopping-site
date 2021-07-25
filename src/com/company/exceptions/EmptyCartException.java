package com.company.exceptions;

public class EmptyCartException extends RuntimeException
{
    public EmptyCartException() {
        super("Can't checkout empty cart");
    }
}
