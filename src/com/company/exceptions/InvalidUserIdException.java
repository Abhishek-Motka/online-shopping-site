package com.company.exceptions;

public class InvalidUserIdException extends RuntimeException
{
    private String userId;

    public InvalidUserIdException(String userId)
    {
        super("User with user id: " + userId + " does not exist");
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }
}
