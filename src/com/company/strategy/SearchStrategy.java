package com.company.strategy;

import com.company.models.Product;

public interface SearchStrategy
{
    boolean filter(Product product);
}
