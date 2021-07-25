package com.company.strategy;

import com.company.models.Product;
import com.company.enums.ProductCategory;

public class SearchByCategoryStrategy implements SearchStrategy
{
    private ProductCategory category;

    public SearchByCategoryStrategy(ProductCategory category)
    {
        this.category = category;
    }

    @Override
    public boolean filter(Product product)
    {
        return product.getCategory().equals(category);
    }
}
