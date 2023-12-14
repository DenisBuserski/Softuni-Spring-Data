package org.example.product_shop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.product_shop.entities.products.ProductWithoutBuyerDTO;
import org.example.product_shop.entities.users.UserWithSoldProductDTO;
import org.example.product_shop.services.ProductService;
import org.example.product_shop.services.SeedService;
import org.example.product_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductShopRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final Gson gson;

    @Autowired
    public ProductShopRunner(SeedService seedService,
                             ProductService productService,
                             UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedUsers();
//        this.seedService.seedCategories();
//        this.seedService.seedProducts();
//        this.seedService.seedAll();

//        query1ProductsInRange();
//        query2SuccessfullySoldProducts();

    }


    private void query1ProductsInRange() {
        List<ProductWithoutBuyerDTO> productsForSell = this.productService.getProductsInPriceRangeForSell(500, 1000);
        String json = this.gson.toJson(productsForSell);
        System.out.println(json);
    }

    private void query2SuccessfullySoldProducts() {
        List<UserWithSoldProductDTO> usersWithSoldProducts = this.userService.getUsersWithSoldProducts();
        String json = this.gson.toJson(usersWithSoldProducts);
        System.out.println(json);
    }
}
