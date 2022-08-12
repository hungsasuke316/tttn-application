package ptit.example.tttnapplication.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Category;
import ptit.example.tttnapplication.data.repositpty.CategoryRepository;
import ptit.example.tttnapplication.dto.request.CategoryRequest;
import ptit.example.tttnapplication.dto.response.CategoryResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotAcceptException;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> getAllCategorys() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryResponse getCategoryByIdDto(Integer categoryId) {
        Optional<Category> categoryOptional = this.categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category =  categoryOptional.get();
            return modelMapper.map(category, CategoryResponse.class);
        }
        throw new ResourceNotFoundException("Category Not Found");
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest dto) {
        Optional<Category> categoryOptional = this.categoryRepository.findByName(dto.getName());

        if (categoryOptional.isPresent()){
            throw new ResourceNotAcceptException("Category already exist");
        }

        Category category = modelMapper.map(dto, Category.class);
        Category saveCategory =categoryRepository.save(category);
        return modelMapper.map(saveCategory, CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategory(Integer categoryId, CategoryRequest dto) {
        Category category = categoryRepository.findById(categoryId).get();
        modelMapper.map(dto,category);
        category = categoryRepository.save(category);
        return  modelMapper.map(category, CategoryResponse.class);
    }
}
