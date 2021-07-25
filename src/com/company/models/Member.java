package com.company.models;


import com.company.exceptions.AdminDeletionNotAllowedException;

import java.util.List;

public class Member extends User
{

    public Member(String name, ContactInfo contactInfo)
    {
        super(name, contactInfo);
    }

    public User deleteAccount() {
        if (isAdmin()) throw new AdminDeletionNotAllowedException();
        SessionManager.getInstance().logout();
        return UserRegistry.getInstance().removeUser(getUserId());
    }

    public ShoppingCart addProductInCart(String productId, int quantity) {
        ShoppingCart cart = ShoppingCart.getInstance(this);
        cart.addItem(productId, quantity);
        return cart;
    }

    public ShoppingCart removeProductFromCart(String productId, int quantity) {
        ShoppingCart cart = ShoppingCart.getInstance(this);
        cart.removeItem(productId, quantity);
        return cart;
    }

    public List<Order> checkout() {
        return ShoppingCart.getInstance(this).checkout();
    }

    @Override
    public boolean isMember()
    {
        return true;
    }

    @Override
    public boolean isSeller()
    {
        return false;
    }

    @Override
    public boolean isAdmin()
    {
        return false;
    }
}
