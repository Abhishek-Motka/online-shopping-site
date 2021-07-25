package com.company.commands;

import com.company.models.Admin;
import com.company.models.Product;

public class RemoveProductCommand extends AbstractAdminCommand
{
    @Override
    public boolean execute(String[] args)
    {
        Admin admin = (Admin) getLoggedInUser();
        Product product = admin.removeProduct(args[1]);
        System.out.println("Removed product: ");
        System.out.println(product.toString());
        return true;
    }
}
