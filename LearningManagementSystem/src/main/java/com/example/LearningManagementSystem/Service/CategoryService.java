package com.example.LearningManagementSystem.Service;

import com.example.LearningManagementSystem.Entity.Category;
import com.example.LearningManagementSystem.Exception.DuplicateResourceException;
import com.example.LearningManagementSystem.Exception.ResourceNotFoundException;
import com.example.LearningManagementSystem.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }

    public Category createCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new DuplicateResourceException("Category with name '" + category.getName() + "' already exists.");
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updated) {
        Category existing = getCategoryById(id);
        if (!existing.getName().equals(updated.getName()) && categoryRepository.existsByName(updated.getName())) {
            throw new DuplicateResourceException("Category with name '" + updated.getName() + "' already exists.");
        }
        existing.setName(updated.getName());
        return categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
