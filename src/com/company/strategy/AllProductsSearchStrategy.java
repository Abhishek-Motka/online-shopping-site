package com.company.strategy;

import com.company.models.Product;

public class AllProductsSearchStrategy implements SearchStrategy
{
    @Override
    public boolean filter(Product product)
    {
        return true;
    }
}
