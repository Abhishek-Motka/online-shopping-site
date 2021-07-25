package com.company.strategy;

import com.company.models.Product;
import com.company.enums.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductSearch
{
    List<Product> getProducts();
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategory(ProductCategory category);
    Optional<Product> getProductById(String productId);
}
