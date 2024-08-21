package com.Ecom.project.service;

import com.Ecom.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
        Category category=categories.stream()
                .filter(c -> c.getCategoryID().equals(categoryID))
                .findFirst().orElse(null);
       if(category==null)
        {
           return "Category notfound.";
        }

       //Thsi part of code is by passing exception.
//        Category category=categories.stream()
//                       .filter(c -> c.getCategoryID().equals(categoryID))
//                .findFirst()
//                   .orElseThrow(()->new categoryNotFoundException("Category not found with ID: "+categoryID));

        categories.remove(category);
        return "Category with categoryID: "+categoryID+" deleted succesfully";
    }

}
