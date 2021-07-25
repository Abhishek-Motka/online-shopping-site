package com.company.models;


public class Guest extends User
{
    public Guest(String name)
    {
        super(name, null);
    }

    public User register(ContactInfo contactInfo) {
        Member member = new Member(getName(), contactInfo);
        UserRegistry.getInstance().addUser(member);
        return member;
    }

    @Override
    public boolean isMember()
    {
        return false;
    }

    @Override
    public boolean isSeller()
    {
        return false;
    }

    @Override
    public boolean isAdmin()
    {
        return false;
    }
}
