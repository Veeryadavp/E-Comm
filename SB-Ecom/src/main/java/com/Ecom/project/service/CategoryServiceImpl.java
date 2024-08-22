package com.Ecom.project.service;

import com.Ecom.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService
{
    List<Category> categories=new ArrayList<Category>();
     private Long nextId=1L;

    @Override
    public List<Category> getAllCategories()
    {
        return categories;
    }

    @Override
    public void createCategory(Category category)
    {
        category.setCategoryID(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryID)
    {

        //here we can write orElse and give as null and if statement to check null.or we can give exception directly. below that code is duplicated check it
//        Category category=categories.stream()
//                .filter(c -> c.getCategoryID().equals(categoryID))
//                .findFirst().orElse(null);
//       if(category==null)
//        {
//           return "Category not found.";
//        }

       //This part of code is by passing exception.
       Category category=categories.stream()
                      .filter(c -> c.getCategoryID().equals(categoryID))
                      .findFirst()
                      .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "response not found"));

        categories.remove(category);
        return "Category with categoryID: "+categoryID+" deleted succesfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryID)
    {
        Optional<Category> optionalCategory=categories.stream()
                .filter(C -> C.getCategoryID().equals(categoryID))
                .findFirst();
        if(optionalCategory.isPresent())
        {
            Category existingCategory=optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found.");
        }

    }

}
