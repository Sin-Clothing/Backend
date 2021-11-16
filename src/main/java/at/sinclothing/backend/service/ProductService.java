package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import com.sun.istack.NotNull;

import java.util.List;

public interface ProductService {
    @NotNull
    List<Product> getAllProducts();

    List<Product> getFilteredProducts(int categoryId);

    Product findProduct(String name);

    Product getProduct(long id);

    void save(Product product);

    void fetchProducts();

}
