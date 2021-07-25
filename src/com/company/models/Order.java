package com.company.models;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order
{
    private static DecimalFormat newFormat = new DecimalFormat("#.##");

    private UUID orderId;
    private String user;
    private String userId;
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private LocalDateTime orderDate;

    public Order(Item item, User user) {
        this.orderId = UUID.randomUUID();
        this.user = user.getName();
        this.userId = user.getUserId().toString();
        Product product = item.getProduct();
        this.productId = product.getProductId().toString();
        this.productName = product.getName();
        this.quantity = item.getQuantity();
        this.price = this.quantity * product.getPrice();
        this.orderDate = LocalDateTime.now();
    }

    public String getProductId()
    {
        return productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public LocalDateTime getOrderDate()
    {
        return orderDate;
    }

    public UUID getOrderId()
    {
        return orderId;
    }

    public String getUser()
    {
        return user;
    }

    public String getUserId()
    {
        return userId;
    }

    @Override
    public String toString()
    {
        return "Order ID: " + orderId +
                "Product ID: " + productId +
                " Product Name: " + productName +
                " Quantity: " + quantity +
                " Price: " + Double.valueOf(newFormat.format(price)) +
                " Order Date: " + orderDate;
    }
}
