package com.company.exceptions;

public class InvalidCommandException extends RuntimeException
{
    public InvalidCommandException() {
        super("Invalid Command!");
    }
}
