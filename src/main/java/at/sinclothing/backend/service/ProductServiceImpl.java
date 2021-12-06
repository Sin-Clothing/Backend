package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import at.sinclothing.backend.pojos.ProductCategory;
import at.sinclothing.backend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    List<Product> products = new ArrayList<>();

    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
        fetchProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Product> getFilteredProducts(long categoryId) {
        if(categoryId == -1) {
            return products;
        }
        return products.stream().filter(p -> p.getProductCategory().getCategoryId().equals(categoryId)).collect(Collectors.toList());
    }

    @Override
    public Product findProduct(String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

    @Override
    public Product getProduct(long id) {
        for (Product product : products) {
            if(product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void fetchProducts() {
        products = productRepository.findAll();
    }

}