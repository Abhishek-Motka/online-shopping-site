package com.company.strategy;

import com.company.models.Product;

public class SearchByNameStrategy implements SearchStrategy
{
    private String name;

    public SearchByNameStrategy(String name)
    {
        this.name = name.toLowerCase();
    }

    @Override
    public boolean filter(Product product)
    {
        return product.getName().toLowerCase().startsWith(name);
    }
}
