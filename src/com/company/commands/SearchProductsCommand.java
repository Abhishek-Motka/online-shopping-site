package com.company.commands;

import com.company.models.Product;
import com.company.models.ProductCatalog;
import com.company.enums.ProductCategory;
import com.company.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchProductsCommand extends AbstractOpenCommand
{
    @Override
    public boolean execute(String[] args)
    {
        ProductCatalog catalog = ProductCatalog.getInstance();
        List<Product> products = new ArrayList<>();
        if (args.length == 1) {
            products.addAll(catalog.getProducts());
        } else if (args.length == 2) {
            throw new InvalidCommandException();
        } else {
            String searchType = args[1];
            String value = args[2];
            if (searchType.equalsIgnoreCase("id")) {
                Optional<Product> productOptional = catalog.getProductById(value);
                if (productOptional.isPresent()) products.add(productOptional.get());
            } else if (searchType.equalsIgnoreCase("category")) {
                products.addAll(catalog.getProductsByCategory(ProductCategory.valueOf(value.toUpperCase())));
            } else if (searchType.equalsIgnoreCase("name")) {
                products.addAll(catalog.getProductsByName(value));
            }
        }

        if (products.size() == 0) {
            System.out.println("No products available for now!");
            return true;
        }

        System.out.println("Products: ");
        for (Product product : products) {
            System.out.print("Id: " + product.getProductId());
            System.out.print(" Name: " + product.getName());
            System.out.print(" Category: " + product.getCategory());
            System.out.print(" Quantity: " + product.getQuantity());
            System.out.print(" Price: " + product.getPrice());
            System.out.println();
        }
        return true;
    }
}
