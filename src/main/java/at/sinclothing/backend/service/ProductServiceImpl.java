package at.sinclothing.backend.service;

import at.sinclothing.backend.pojos.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    EntityManagerFactory emf;
    EntityManager em;

    List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        emf = Persistence.createEntityManagerFactory("PU_Sin-Clothing");
        em = emf.createEntityManager();
        fetchProducts();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
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
        Query query = em.createNamedQuery("Product.getAll");
        products = query.getResultList();
    }
}