package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import com.sun.istack.NotNull;

import java.util.List;

public interface ProductService {
    @NotNull
    List<Product> getAllProducts();

    Product getProduct(long id);

    void save(Product product);

    void fetchProducts();

}
