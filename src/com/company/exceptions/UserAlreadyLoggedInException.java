package com.company.exceptions;

import com.company.models.User;

public class UserAlreadyLoggedInException extends RuntimeException
{
    private User user;

    public UserAlreadyLoggedInException(User loggedInUser)
    {
        super("User " + loggedInUser.getName() + " is already logged in.");
        this.user = loggedInUser;
    }

    public User getUser()
    {
        return user;
    }
}
