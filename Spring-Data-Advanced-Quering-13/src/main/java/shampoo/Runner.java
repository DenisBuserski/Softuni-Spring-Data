package shampoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shampoo.enums.Size;
import shampoo.serivices.IngredientService;
import shampoo.serivices.ShampooService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        // this.shampooRepository.findByBrand("Cotton Fresh").forEach(shampoo -> System.out.println(shampoo.getId()));
        // this.shampooRepository.findAllByBrandAndSize("Cotton Fresh", Size.SMALL).forEach(s -> System.out.println(s.getId()));

        Scanner scanner = new Scanner(System.in);
        int exerciseNumber = Integer.parseInt(scanner.nextLine());
        switch (exerciseNumber) {
            case 1 -> selectShampoosBySize_01(scanner);
            case 2 -> selectShampoosBySizeOrLabel_02(scanner);
            case 3 -> selectShampoosByPrice_03(scanner);
            case 4 -> selectIngredientsByName_04(scanner);
            case 5 -> selectIngredientsByNames_05(scanner);
            case 6 -> countShampoosByPrice_06(scanner);
        }


    }

    private void selectShampoosBySize_01(Scanner scanner) {
        String sizeName = scanner.nextLine().toUpperCase();
        Size size = Size.valueOf(sizeName);
        this.shampooService.findBySizeOrderById(size).forEach(System.out::println);
    }

    private void selectShampoosBySizeOrLabel_02(Scanner scanner) {
        String sizeName = scanner.nextLine().toUpperCase();
        Size size = Size.valueOf(sizeName);
        int labelId = Integer.parseInt(scanner.nextLine());
        this.shampooService.selectBySizeOrLabelId(size, labelId).forEach(System.out::println);
    }

    public void selectShampoosByPrice_03(Scanner scanner) {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        this.shampooService.selectMoreExpensiveThan(price).forEach(System.out::println);
    }

    public void selectIngredientsByName_04(Scanner scanner) {
        String input = scanner.nextLine();
        this.ingredientService.selectNameStartsWith(input).forEach(i -> System.out.println(i.getName()));
    }

    public void selectIngredientsByNames_05(Scanner scanner) {
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        this.ingredientService.selectInNames(names).forEach(i -> System.out.println(i.getName()));
    }

    public void countShampoosByPrice_06(Scanner scanner) {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        System.out.println(this.shampooService.countPriceLowerThan(price));
    }
}
