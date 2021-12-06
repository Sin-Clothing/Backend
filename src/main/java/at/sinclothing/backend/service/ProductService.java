package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import at.sinclothing.backend.pojos.ProductCategory;
import com.sun.istack.NotNull;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getFilteredProducts(long categoryId);

    Product findProduct(String name);

    Product getProduct(long id);

    void save(Product product);

    void fetchProducts();

}
