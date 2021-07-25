package com.company.commands;

import com.company.models.User;


public class UserInfoCommand extends AbstractGuestCommand
{
    @Override
    public boolean execute(String[] args)
    {
        User user = getLoggedInUser();
        System.out.println("Name: " + user.getName());
        if (user.isMember()) {
            System.out.println("Contact Info:");
            System.out.println(user.getContactInfo().toString());
        }
        return true;
    }
}
