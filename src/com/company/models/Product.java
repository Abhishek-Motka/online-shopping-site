package com.company.models;

import com.company.enums.ProductCategory;

import java.util.UUID;

public class Product
{
    private UUID productId;
    private String name;
    private String description;
    private ProductCategory category;
    private double price;
    private int quantity;

    public Product(String name, String description, ProductCategory category, double price, int quantity)
    {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public ProductCategory getCategory()
    {
        return category;
    }

    public Double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public UUID getProductId()
    {
        return productId;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Id: " + productId +
                " Name: " + name +
                " Category: " + category +
                " Price: " + price +
                " Quantity: " + quantity;
    }
}
