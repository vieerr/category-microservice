package com.saintroche.categories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saintroche.categories.models.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
