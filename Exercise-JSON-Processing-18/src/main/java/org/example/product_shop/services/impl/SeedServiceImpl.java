package org.example.product_shop.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.product_shop.entities.categories.CategoryImportDTO;
import org.example.product_shop.entities.categories.Category;
import org.example.product_shop.entities.users.User;
import org.example.product_shop.entities.users.UserImportDTO;
import org.example.product_shop.repositories.CategoryRepository;
import org.example.product_shop.repositories.UserRepository;
import org.example.product_shop.services.SeedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private static final String USER_JSON_PATH = "src/main/resources/product_shop/users.json";
    private static final String CATEGORIES_JSON_PATH = "src/main/resources/product_shop/categories.json";
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(USER_JSON_PATH);
        UserImportDTO[] userImportDTOS = this.gson.fromJson(fileReader, UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH);
        CategoryImportDTO[] categoriesImportDTOS = this.gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categories = Arrays.stream(categoriesImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);

    }

    @Override
    public void seedProducts() {

    }
}
