package shampoo_company;

import shampoo_company.entities.Size;
import shampoo_company.repositories.ShampooRepository;
import shampoo_company.services.IngredientService;
import shampoo_company.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(
            ShampooService shampooService,
            IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int ex = Integer.parseInt(scanner.nextLine());
        while (ex != 0) {
            switch (ex) {
                case 1 -> selectShampoosBySize01();
                case 2 -> selectShampoosBySizeOrLabel02();
                case 3 -> selectShampoosByPrice03();
                case 4 -> selectIngredientsByName04();
                case 5 -> selectIngredientsByNames05();
                case 6 -> countShampoosByPrice06();
                case 7 -> selectShampoosByIngredients07();
                case 8 -> selectShampoosByIngredientsCount08();
                case 9 -> deleteIngredientsByName09();
                case 10 -> updateIngredientsByPrice10();
                case 11 -> updateIngredientsByNames11();
            }
            ex = Integer.parseInt(scanner.nextLine());
        }

    }

    private void updateIngredientsByNames11() {
        List<String> ingredients = List.of("Macadamia Oil", "Aloe Vera", "Lavender");
        this.ingredientService.increasePriceOfIngredients(ingredients);
        System.out.println("Price successfully increased");

    }

    private void updateIngredientsByPrice10() {
        this.ingredientService.increasePriceByPercentage(0.1);
        System.out.println("Price successfully increased");
    }

    private void deleteIngredientsByName09() {
        System.out.println(this.ingredientService.deleteByName("Nettle"));
    }

    private void selectShampoosByIngredientsCount08() {
        this.shampooService.selectByIngredientCount(2)
                .forEach(s -> System.out.println(s.getBrand()));
    }

    private void selectShampoosByIngredients07() {
        List<String> names = List.of("Berry", "Mineral-Collagen");
        this.shampooService.findByIngredientsNames(names)
                .forEach(System.out::println);
    }

    private void countShampoosByPrice06() {
        System.out.println(this.shampooService.countByPriceLowerThan(BigDecimal.valueOf(8.5)));
    }

    private void selectIngredientsByNames05() {
        this.ingredientService.selectInNames(List.of("Lavender", "Herbs", "Apple"))
                .forEach(System.out::println);
    }

    private void selectIngredientsByName04() {
        this.ingredientService.selectNameStartsWith("M")
                .forEach(System.out::println);
    }

    private void selectShampoosByPrice03() {
        this.shampooService.selectMoreExpensiveThan(BigDecimal.valueOf(5))
                .forEach(System.out::println);
    }

    private void selectShampoosBySizeOrLabel02() {
        this.shampooService.selectBySizeORLabelId(Size.MEDIUM, 10)
                .forEach(System.out::println);
    }

    private void selectShampoosBySize01() {
        this.shampooService.selectBySize(Size.MEDIUM)
                .forEach(System.out::println);
    }
}
