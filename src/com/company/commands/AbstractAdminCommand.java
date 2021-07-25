package com.company.commands;

public abstract class AbstractAdminCommand extends AbstractMemberCommand
{
    @Override
    public boolean requiresAdmin()
    {
        return true;
    }
}
