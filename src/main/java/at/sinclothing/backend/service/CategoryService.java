package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import at.sinclothing.backend.pojos.ProductCategory;

import java.util.List;

public interface CategoryService {

    void fetchCategories();

    List<ProductCategory> getAllCategories();
}
