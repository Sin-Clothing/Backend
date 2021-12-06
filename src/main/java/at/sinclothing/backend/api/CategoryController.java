package at.sinclothing.backend.api;

import at.sinclothing.backend.pojos.ProductCategory;
import at.sinclothing.backend.repo.ProductCategoryRepository;
import at.sinclothing.backend.service.CategoryService;
import at.sinclothing.backend.service.CategoryServiceImpl;
import at.sinclothing.backend.service.ProductService;
import at.sinclothing.backend.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("category")
@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PUT})
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public List<ProductCategory> listCategories() {
        return categoryService.getAllCategories();
    }

}
