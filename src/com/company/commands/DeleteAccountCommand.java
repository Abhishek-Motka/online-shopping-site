package com.company.commands;

import com.company.models.Member;

public class DeleteAccountCommand extends AbstractMemberCommand
{
    @Override
    public boolean execute(String[] args)
    {
        Member user = (Member) getLoggedInUser();
        user.deleteAccount();
        System.out.println("Account for user " + user.getName() + " deleted.");
        return true;
    }
}
