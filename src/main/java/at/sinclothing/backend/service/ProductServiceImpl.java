package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProduct(long id) {
        for (Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}
