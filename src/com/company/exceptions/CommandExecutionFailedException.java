package com.company.exceptions;

public class CommandExecutionFailedException extends RuntimeException
{
    public CommandExecutionFailedException()
    {
        super("Command execution failed");
    }
}
