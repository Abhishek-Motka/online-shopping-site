package com.company.exceptions;

public class UserNotLoggedInException extends RuntimeException
{
    public UserNotLoggedInException() {
        super("Please login to run this command");
    }
}
