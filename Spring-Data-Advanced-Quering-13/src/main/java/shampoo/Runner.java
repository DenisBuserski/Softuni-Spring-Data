package shampoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shampoo.entities.Shampoo;
import shampoo.enums.Size;
import shampoo.repositories.ShampooRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;

    @Autowired
    public Runner(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // this.shampooRepository.findByBrand("Cotton Fresh").forEach(shampoo -> System.out.println(shampoo.getId()));
        // this.shampooRepository.findAllByBrandAndSize("Cotton Fresh", Size.SMALL).forEach(s -> System.out.println(s.getId()));

        Scanner scanner = new Scanner(System.in);
        int exerciseNumber = Integer.parseInt(scanner.nextLine());
        switch (exerciseNumber) {
            case 1 -> selectShampoosBySize_01(scanner);
        }


    }

    private void selectShampoosBySize_01(Scanner scanner) {
        String sizeName = scanner.nextLine().toUpperCase();
        Size size = Size.valueOf(sizeName);
        this.shampooRepository.findBySizeOrderById(size).forEach(System.out::println);
    }
}