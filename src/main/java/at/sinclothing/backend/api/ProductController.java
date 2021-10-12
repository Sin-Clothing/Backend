package at.sinclothing.backend.api;

import at.sinclothing.backend.pojos.Product;
import at.sinclothing.backend.service.ProductService;
import at.sinclothing.backend.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("")
@RestController
public class ProductController {

    private ProductService productService = new ProductServiceImpl();

    @GetMapping("test")
    String test() {
        return "Sünden sind periodisch und wiederkehren d.";
    }

    @GetMapping("products")
    List<Product> products() {
        return productService.getAllProducts();
    }

}
