package com.fashionworld.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fashionworld.major.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	

}
