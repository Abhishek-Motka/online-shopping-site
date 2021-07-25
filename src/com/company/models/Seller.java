package com.company.models;


public class Seller extends Member
{
    private String GST_NO;

    public Seller(String name, ContactInfo contactInfo, String GST_NO)
    {
        super(name, contactInfo);
        this.GST_NO = GST_NO;
    }

    public String getGST_NO()
    {
        return GST_NO;
    }

    @Override
    public boolean isSeller()
    {
        return true;
    }
}
