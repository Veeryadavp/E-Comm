package com.Ecom.project.service;

import com.Ecom.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService
{
List<Category> getAllCategories();
public void createCategory(Category category);

}
