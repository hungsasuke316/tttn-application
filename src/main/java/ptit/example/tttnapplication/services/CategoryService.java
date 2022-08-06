package ptit.example.tttnapplication.services;

import ptit.example.tttnapplication.data.entity.Category;
import ptit.example.tttnapplication.dto.request.CategoryRequestDto;
import ptit.example.tttnapplication.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategorys();
    CategoryResponse getCategoryByIdDto(Integer categoryId);
    CategoryResponse createCategory(CategoryRequestDto dto);
    CategoryResponse updateCategory(Integer categoryId, CategoryRequestDto dto);
}
