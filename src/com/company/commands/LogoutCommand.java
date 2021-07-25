package com.company.commands;

import com.company.models.SessionManager;

public class LogoutCommand extends AbstractGuestCommand
{
    @Override
    public boolean execute(String[] args)
    {
        SessionManager.getInstance().logout();
        return true;
    }
}
