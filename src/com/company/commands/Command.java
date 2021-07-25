package com.company.commands;

public interface Command
{
    boolean requiresLoggedInUser();
    boolean requiresMember();
    boolean requiresAdmin();
    boolean execute(String[] args);
}
