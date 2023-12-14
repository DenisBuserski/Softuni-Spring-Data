package org.example.product_shop.services.impl;

import com.google.gson.Gson;
import org.example.product_shop.repositories.UserRepository;
import org.example.product_shop.services.SeedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedUsers() {


    }

    @Override
    public void seedCategories() {

    }

    @Override
    public void seedProducts() {

    }
}
