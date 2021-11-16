package at.sinclothing.backend.api;

import at.sinclothing.backend.pojos.Product;
import at.sinclothing.backend.service.ProductService;
import at.sinclothing.backend.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT})
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

    @GetMapping("filteredProducts")
    List<Product> filterProducts(@RequestParam int categoryId){
        return productService.getFilteredProducts(categoryId);
    }

    @GetMapping("findProduct")
    Product findProduct(@RequestParam String name){
        return productService.findProduct(name);
    }
}
