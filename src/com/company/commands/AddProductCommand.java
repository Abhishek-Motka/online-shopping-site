package com.company.commands;

import com.company.models.Admin;
import com.company.models.Product;
import com.company.enums.ProductCategory;
import com.company.exceptions.InvalidCommandException;

public class AddProductCommand extends AbstractAdminCommand
{
    @Override
    public boolean execute(String[] args)
    {
        if (args.length != 6) throw new InvalidCommandException();
        ProductCategory category = ProductCategory.valueOf(args[3].toUpperCase());
        double price = Double.parseDouble(args[4]);
        int qty = Integer.parseInt(args[5]);
        if (price < 0 || qty < 0) throw new IllegalArgumentException("Price or Quantity can't be negative");
        Product product = new Product(args[1], args[2], category, price, qty);
        Admin admin = (Admin) getLoggedInUser();
        admin.addProduct(product);
        System.out.println("Added product: ");
        System.out.println(product.toString());
        return true;
    }
}
