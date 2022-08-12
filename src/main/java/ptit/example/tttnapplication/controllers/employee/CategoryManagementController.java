package ptit.example.tttnapplication.controllers.employee;

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
@RequestMapping("/employee")
public class CategoryManagementController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryManagementController(CategoryService categoryService) {
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

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    CategoryResponse createCategory(@Valid @RequestBody CategoryRequest dto){
        return this.categoryService.createCategory(dto);
    }

    @PutMapping("/category/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    CategoryResponse updateCategory(@PathVariable("categoryId") Integer categoryId, @Valid @RequestBody CategoryRequest dto){
        return this.categoryService.updateCategory(categoryId,dto);
    }
}
