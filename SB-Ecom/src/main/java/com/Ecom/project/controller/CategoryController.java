package com.Ecom.project.controller;


import com.Ecom.project.model.Category;
import com.Ecom.project.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController
{
    //Here the dependencies being injected in the controller ,CategoryService is an interface it is not marked as a service.instead -
    //its implementation is marked as a service i.e. "CategoryServiceImpl" ,so during run time a type of category service is being injected over here.
    //below we are using constructor injection (or) we can make use of field injection as well just mention @Autowired above the field.
    //Class CategoryController depends on CategoryService which is injected via constructor and springs handles  this DI automatically.
   private CategoryService categoryService;


   public CategoryController(CategoryService categoryService)
   {
       this.categoryService=categoryService;
   }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @PostMapping ("/api/public/categories")
    public String createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return " Category created successfully.";
    }

    @DeleteMapping("/api/admin/categories/{categoryID}")
    public String deleteCategory(@PathVariable Long categoryID)
    {
        String Status=categoryService.deleteCategory(categoryID);
        return Status;
    }
}
