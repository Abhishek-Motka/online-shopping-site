package com.company.exceptions;

import com.company.models.Product;

public class ProductNotAddedInCartException extends RuntimeException
{
    private Product product;

    public ProductNotAddedInCartException(Product product)
    {
        super("Product not found in your cart: " + product.getName());
        this.product = product;
    }

    public Product getProduct()
    {
        return product;
    }
}
