package com.company.models;

public class ContactInfo
{
    private String emailAddress;
    private String phoneNumber;
    private String address;

    public ContactInfo(String emailAddress, String phoneNumber, String address)
    {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Email: " + emailAddress + "\nPhone: " + phoneNumber + "\nAddress: " + address;
    }
}
