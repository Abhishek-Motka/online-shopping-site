package com.company.commands;

import com.company.models.SessionManager;

import java.util.regex.Pattern;

public class LoginCommand extends AbstractOpenCommand
{
    private static Pattern email = Pattern.compile("[a-zA-Z-.0-9]+@[a-zA-Z0-9]+.[a-zA-Z]+");

    @Override
    public boolean execute(String[] args)
    {
        if (args.length == 1) {
            SessionManager.getInstance().login();
        } else {
            if (email.matcher(args[1]).matches()) {
                SessionManager.getInstance().loginWithEmail(args[1]);
            } else {
                SessionManager.getInstance().login(args[1]);
            }
        }
        return true;
    }
}
