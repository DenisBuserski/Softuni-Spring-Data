package org.example.product_shop.services;

public interface SeedService {
    void seedUsers();

    void seedCategories();

    void seedProducts();

    default void seedAll() {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
