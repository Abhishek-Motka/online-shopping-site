package com.company.commands;

import com.company.models.Admin;
import com.company.models.Product;
import com.company.exceptions.InvalidCommandException;

public class UpdateQtyCommand extends AbstractAdminCommand
{
    @Override
    public boolean execute(String[] args)
    {
        Admin admin = (Admin) getLoggedInUser();
        if (args.length != 3) throw new InvalidCommandException();
        int changeQty = Integer.parseInt(args[2]);
        Product product = admin.updateQuantity(args[1], changeQty);
        System.out.println("Updated product inventory: ");
        System.out.println(product.toString());
        return true;
    }
}
