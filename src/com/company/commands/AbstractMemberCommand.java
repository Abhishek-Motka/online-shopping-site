package com.company.commands;

public abstract class AbstractMemberCommand extends AbstractGuestCommand
{
    @Override
    public boolean requiresMember()
    {
        return true;
    }
}
