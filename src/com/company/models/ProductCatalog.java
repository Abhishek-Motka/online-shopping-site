package com.company.models;

import com.company.enums.ProductCategory;
import com.company.exceptions.InvalidProductIdException;
import com.company.exceptions.ProductNotExistException;
import com.company.strategy.*;

import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog implements ProductSearch
{
    private static ProductCatalog catalog;

    private Map<UUID, Product> productsMap;
    private List<Product> products;

    private ProductCatalog()
    {
        productsMap = new HashMap<>();
        products = new ArrayList<>();
    }

    public static ProductCatalog getInstance() {
        if (Objects.nonNull(catalog)) return catalog;
        synchronized (ProductCatalog.class) {
            if (Objects.isNull(catalog))
                catalog = new ProductCatalog();
        }
        return catalog;
    }

    public void addProduct(Product product) {
        productsMap.put(product.getProductId(), product);
        products.add(product);
    }

    public Product removeProduct(String productId) {
        Product product = getProduct(productId);
        products.remove(product);
        return product;
    }

    private Product getProduct(String productId) {
        Optional<Product> productOptional = getProductById(productId);
        if (!productOptional.isPresent()) throw new ProductNotExistException(productId);
        return productOptional.get();
    }

    @Override
    public List<Product> getProducts()
    {
        return search(new AllProductsSearchStrategy());
    }

    @Override
    public List<Product> getProductsByName(String name)
    {
        return search(new SearchByNameStrategy(name));
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory category)
    {
        return search(new SearchByCategoryStrategy(category));
    }

    @Override
    public Optional<Product> getProductById(String productId)
    {
        try {
            return Optional.ofNullable(productsMap.get(UUID.fromString(productId)));
        } catch (IllegalArgumentException ex) {
            throw new InvalidProductIdException(productId);
        }
    }

    private List<Product> search(SearchStrategy searchStrategy) {
        return products.stream().filter(searchStrategy::filter).collect(Collectors.toList());
    }
}
