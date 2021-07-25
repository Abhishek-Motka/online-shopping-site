package com.company.models;


import java.text.DecimalFormat;

public class Item
{
    private static DecimalFormat newFormat = new DecimalFormat("#.##");
    private Product product;
    private int quantity;

    public Item(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public void updateQty(int change) {
        if (quantity + change < 0) quantity = 0;
        quantity += change;
    }

    @Override
    public String toString()
    {
        return "Product ID: " + product.getProductId() +
                " Product Name: " + product.getName() +
                " Quantity: " + quantity +
                " Price: " + Double.valueOf(newFormat.format(quantity * product.getPrice()));
    }
}
