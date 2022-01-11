package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.ProductCategory;
import at.sinclothing.backend.repo.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    ProductCategoryRepository categoryRepository;

    List<ProductCategory> categories = new ArrayList<>();

    public CategoryServiceImpl(@Autowired ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        fetchCategories();
    }

    @Override
    public void fetchCategories() {
        categories = categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> getAllCategories() {
        return categories;
    }
}
