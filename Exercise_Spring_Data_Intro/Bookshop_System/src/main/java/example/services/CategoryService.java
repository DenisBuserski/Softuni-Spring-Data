package example.services;

import example.entities.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> getRandomCategories();
}
