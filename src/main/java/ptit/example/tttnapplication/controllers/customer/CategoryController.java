package ptit.example.tttnapplication.controllers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Category;
import ptit.example.tttnapplication.dto.request.CategoryRequest;
import ptit.example.tttnapplication.dto.response.CategoryResponse;
import ptit.example.tttnapplication.services.CategoryService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/customer")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    List<Category> getAllCategory(){
        return this.categoryService.getAllCategorys();
    }

    @GetMapping("/category/{categoryId}")
    CategoryResponse getCategoryById(@PathVariable("categoryId") Integer categoryId){
        return this.categoryService.getCategoryByIdDto(categoryId);
    }
}
