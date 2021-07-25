package com.company.models;

import com.company.exceptions.EmptyCartException;
import com.company.exceptions.InvalidProductIdException;
import com.company.exceptions.ProductNotAddedInCartException;

import java.util.*;
import java.util.stream.Collectors;

public class ShoppingCart
{
    private static Map<UUID, ShoppingCart> carts = new HashMap<>();

    private List<Item> items;
    private User user;

    private ShoppingCart(User user) {
        this.items = new ArrayList<>();
        this.user = user;
    }

    public static ShoppingCart getInstance(User user) {
        UUID userId = user.getUserId();
        carts.keySet().stream().forEach(System.out::println);
        if (carts.containsKey(userId)) return carts.get(userId);
        synchronized (ShoppingCart.class) {
            if (!carts.containsKey(userId)) {
                carts.put(userId, new ShoppingCart(user));
            }
        }
        return carts.get(userId);
    }

    public void addItem(String productId, int quantity) {
        if (quantity <= 0) throw new RuntimeException("Quantity of product to add in cart should be positive");
        Product product = getProduct(productId);
        for (Item item : items) {
            if (item.getProduct().equals(product)) {
                item.updateQty(quantity);
                return;
            }
        }
        Item item = new Item(product, quantity);
        items.add(item);
    }

    public void removeItem(String productId, int quantity) {
        if (quantity <= 0) throw new RuntimeException("Quantity of product to remove in cart should be positive");
        Product product = getProduct(productId);
        for (Item item : items) {
            if (item.getProduct().equals(product)) {
                item.updateQty(-quantity);
                return;
            }
        }
        throw new ProductNotAddedInCartException(product);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Order> checkout() {
        if (items.size() == 0) throw new EmptyCartException();
        System.out.println(items.size());
        List<Order> orders = items.stream().map(item -> new Order(item, user)).collect(Collectors.toList());
        items.clear();
        return orders;
    }

    private Product getProduct(String productId) {
        Optional<Product> product = ProductCatalog.getInstance().getProductById(productId);
        if (!product.isPresent()) throw new InvalidProductIdException(productId);
        return product.get();
    }
}
