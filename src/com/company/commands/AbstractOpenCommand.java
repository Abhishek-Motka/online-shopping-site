package com.company.commands;

public abstract class AbstractOpenCommand implements Command
{
    @Override
    public boolean requiresLoggedInUser()
    {
        return false;
    }

    @Override
    public boolean requiresMember()
    {
        return false;
    }

    @Override
    public boolean requiresAdmin()
    {
        return false;
    }
}
