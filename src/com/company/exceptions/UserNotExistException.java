package com.company.exceptions;

import java.util.UUID;

public class UserNotExistException extends RuntimeException
{
    private String userId;

    public UserNotExistException(UUID userId)
    {
        this(userId.toString());
    }

    public UserNotExistException(String userId)
    {
        super("User with " + userId + " does not exist in the system");
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
}
