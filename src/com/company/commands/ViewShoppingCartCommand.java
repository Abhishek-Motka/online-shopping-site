package com.company.commands;

import com.company.models.Item;
import com.company.models.ShoppingCart;
import com.company.models.User;

import java.util.List;

public class ViewShoppingCartCommand extends AbstractMemberCommand
{
    @Override
    public boolean execute(String[] args)
    {
        User user = getLoggedInUser();
        ShoppingCart cart = ShoppingCart.getInstance(user);
        List<Item> itemsInCart = cart.getItems();
        System.out.println("Shopping Cart:");
        if (itemsInCart.size() == 0) System.out.println("Your cart is empty!");
        else itemsInCart.stream().map(Item::toString).forEach(System.out::println);
        return true;
    }
}
