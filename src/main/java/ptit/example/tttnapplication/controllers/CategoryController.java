package ptit.example.tttnapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Category;
import ptit.example.tttnapplication.dto.request.CategoryRequestDto;
import ptit.example.tttnapplication.dto.response.CategoryResponse;
import ptit.example.tttnapplication.services.CategoryService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getAllCategory(){
        return this.categoryService.getAllCategorys();
    }

    @GetMapping("/{categoryId}")
    CategoryResponse getCategoryById(@PathVariable("categoryId") Integer categoryId){
        return this.categoryService.getCategoryByIdDto(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CategoryResponse createCategory(@Valid @RequestBody CategoryRequestDto dto){
        return this.categoryService.createCategory(dto);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    CategoryResponse updateCategory(@PathVariable("categoryId") Integer categoryId, @Valid @RequestBody CategoryRequestDto dto){
        return this.categoryService.updateCategory(categoryId,dto);
    }
}
