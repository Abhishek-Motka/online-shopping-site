package com.company.exceptions;

public class ProductNotExistException extends RuntimeException
{
    private String productId;

    public ProductNotExistException(String productId)
    {
        super("Product does not exist with id: " + productId);
        this.productId = productId;
    }

    public String getProductId()
    {
        return productId;
    }
}
