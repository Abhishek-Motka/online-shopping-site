package com.company.exceptions;

public class InvalidProductQuantityException extends RuntimeException
{
    private int quantity;

    public InvalidProductQuantityException(int i)
    {
        super("Can't set quantity of product to: " + i);
        this.quantity = i;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
