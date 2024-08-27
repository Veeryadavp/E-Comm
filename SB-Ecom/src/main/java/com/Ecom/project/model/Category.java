package com.Ecom.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;


//This annotation will convert class in to  a table -
// and the categoryID attribute should be give @ID annotation -
// because we should have atleast one unique attribute/column this annotation makes this attribute unique.
//name attribute of @Entity annotation halps to rename the table name as per our need.
@Entity(name="Categories")
@Data
@AllowNonPortable
@NoArgsConstructor
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;
    private String categoryName;


}

