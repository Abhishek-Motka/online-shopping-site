package com.company.models;

import com.company.enums.AccountStatus;

import java.util.Objects;
import java.util.UUID;

public abstract class User
{
    private UUID userId;
    private String name;
    private ContactInfo contactInfo;
    private AccountStatus status;

    public User(String name, ContactInfo contactInfo)
    {
        this.name = name;
        this.contactInfo = contactInfo;
        this.status = AccountStatus.ACTIVE;
        this.userId = UUID.randomUUID();
    }

    public UUID getUserId()
    {
        return userId;
    }

    public String getName()
    {
        return name;
    }

    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    public AccountStatus getStatus()
    {
        return status;
    }

    public void setStatus(AccountStatus status)
    {
        this.status = status;
    }

    public abstract boolean isMember();

    public abstract boolean isSeller();

    public abstract boolean isAdmin();

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userId);
    }
}
