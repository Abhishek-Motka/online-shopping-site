package com.company.exceptions;

public class AdminDeletionNotAllowedException extends RuntimeException
{
    public AdminDeletionNotAllowedException() {
        super("Can't delete admin account from the system!");
    }
}
