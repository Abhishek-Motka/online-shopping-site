package com.company.exceptions;

import com.company.models.User;

public class InvalidUserException extends RuntimeException
{
    private User user;

    public InvalidUserException(User user, String s)
    {
        super(s);
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }
}
