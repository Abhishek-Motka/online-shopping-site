package com.company.commands;

import com.company.models.SessionManager;
import com.company.models.User;

public abstract class AbstractGuestCommand extends AbstractOpenCommand
{
    @Override
    public boolean requiresLoggedInUser()
    {
        return true;
    }

    public User getLoggedInUser() {
        return SessionManager.getInstance().getLoggedInUser().get();
    }
}
