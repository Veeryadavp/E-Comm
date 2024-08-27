package com.Ecom.project.com.Ecom.project.repositories;

import com.Ecom.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
}
