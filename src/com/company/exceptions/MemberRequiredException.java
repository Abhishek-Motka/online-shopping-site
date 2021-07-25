package com.company.exceptions;

public class MemberRequiredException extends RuntimeException
{
    public MemberRequiredException() {
        super("Can't run this command as Guest user");
    }
}
