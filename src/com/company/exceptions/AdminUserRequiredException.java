package com.company.exceptions;

public class AdminUserRequiredException extends RuntimeException
{
    public AdminUserRequiredException() {
        super("Admin user is required to run this command");
    }
}
