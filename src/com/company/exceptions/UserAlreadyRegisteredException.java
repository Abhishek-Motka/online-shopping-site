package com.company.exceptions;

import com.company.models.User;

public class UserAlreadyRegisteredException extends RuntimeException
{
    private User user;

    public UserAlreadyRegisteredException(User user)
    {
        super("User " + user.getName() + " is already registered in the system");
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }
}
