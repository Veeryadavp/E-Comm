package com.Ecom.project.service;

import com.Ecom.project.model.Category;

import java.util.List;

public interface CategoryService
{
List<Category> getAllCategories();
public void createCategory(Category category);
public String deleteCategory(Long categoryI);
}
