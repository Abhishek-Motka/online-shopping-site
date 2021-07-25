package com.company.exceptions;

public class InvalidProductIdException extends RuntimeException
{
    private String productId;

    public InvalidProductIdException(String productId)
    {
        super("Invalid product id: " + productId);
        this.productId = productId;
    }

    public String getProductId()
    {
        return productId;
    }
}
