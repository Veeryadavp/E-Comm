package com.Ecom.project.controller;


import com.Ecom.project.model.Category;
import com.Ecom.project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<Category>> getAllCategories()
    {
        return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }

    @PostMapping ("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>(" Category created successfully.", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryID}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryID) {
        try {
            String Status = categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(Status, HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
           return  new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/api/public/categories/{categoryID}")
    public ResponseEntity<String> UpdateCategory(@RequestBody Category category, @PathVariable Long categoryID )
    {
        try{
            Category savedCategory=categoryService.updateCategory(category, categoryID);
            return new ResponseEntity<>("Category with categoryID: "+categoryID+" updated successfully.", HttpStatus.OK);
        }
        catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
