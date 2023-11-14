package com.springboot.javaguides.model;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document (collection = "products")
@Data
public class Product {
	
	@Id
	private long id;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String name;
	
	private String description;
}
