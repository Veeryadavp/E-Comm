package com.Ecom.project.service;

import com.Ecom.project.com.Ecom.project.repositories.CategoryRepository;
import com.Ecom.project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService
{
   // List<Category> categories=new ArrayList<Category>();
     private Long nextId=1L;

     @Autowired
     private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category)
    {
        category.setCategoryID(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryID)
    {
        Category category =categoryRepository.findById(categoryID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        //here we can write orElse and give as null and if statement to check null.or we can give exception directly. below that code is duplicated check it
//        Category category=categories.stream()
//                .filter(c -> c.getCategoryID().equals(categoryID))
//                .findFirst().orElse(null);
//       if(category==null)
//        {
//           return "Category not found.";
//        }
// This part of code is by passing exception.

//       Category category=categories.stream()
//                      .filter(c -> c.getCategoryID().equals(categoryID))
//                      .findFirst()
//                      .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "response not found"));
//
       categoryRepository.delete(category);
        return "Category with categoryID: "+categoryID+" deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryID)
    {

        Category savedCategory= categoryRepository.findById(categoryID)
         .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with categoryID: "+categoryID+" not found"));
        category.setCategoryID(categoryID);
        savedCategory =categoryRepository.save(category);
        return savedCategory;

//        Optional<Category> optionalCategory= savedCategoryOptional.stream()
//                .filter(C -> C.getCategoryID().equals(categoryID))
//                .findFirst();

//        if(optionalCategory.isPresent())
//        {
//            Category existingCategory=optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedcategory= categoryRepository.save(existingCategory);
//            return savedcategory;
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
//        }
    }

}
