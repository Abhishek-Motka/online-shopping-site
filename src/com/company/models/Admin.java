package com.company.models;

import com.company.enums.AccountStatus;
import com.company.exceptions.InvalidProductIdException;
import com.company.exceptions.InvalidProductQuantityException;
import com.company.exceptions.UserNotExistException;

import java.util.Optional;

public class Admin extends Member
{
    public Admin(String name, ContactInfo contactInfo)
    {
        super(name, contactInfo);
    }

    public void blockUser(String userId) {
        getUser(userId).setStatus(AccountStatus.BLOCKED);
    }

    public void unblockUser(String userId) {
        getUser(userId).setStatus(AccountStatus.ACTIVE);
    }

    public void addProduct(Product product) {
        ProductCatalog.getInstance().addProduct(product);
    }

    public Product removeProduct(String productId) {
        return ProductCatalog.getInstance().removeProduct(productId);
    }

    public Product updateQuantity(String productId, int quantity) {
        Optional<Product> productOptional = ProductCatalog.getInstance().getProductById(productId);
        if (!productOptional.isPresent()) throw new InvalidProductIdException(productId);
        Product product = productOptional.get();
        int qty = product.getQuantity();
        if (qty + quantity < 0) throw new InvalidProductQuantityException(qty + quantity);
        product.setQuantity(qty + quantity);
        return product;
    }

    private User getUser(String userId) {
        Optional<User> userOptional = UserRegistry.getInstance().getUser(userId);
        if (!userOptional.isPresent()) throw new UserNotExistException(userId);
        return userOptional.get();
    }

    @Override
    public boolean isAdmin()
    {
        return true;
    }
}
