import entities.*;
import enums.ClothSize;
import enums.Color;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Appliance appliance = createSampleAppliance();
        Beverage beverage = createSampleBeverage();
        Food food = createSampleFood();
        Cloth cloth = createSampleCloth();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProducts(List.of(appliance, beverage, food, cloth));

        Cashier cashier = new Cashier();
        cashier.printReceipt(shoppingCart.getProducts(), LocalDateTime.now());
    }

    private static Cloth createSampleCloth() {
        Cloth cloth = new Cloth();
        cloth.setName("Shirt");
        cloth.setBrand("New Yorker");
        cloth.setPrice(11.99);
        cloth.setSize(ClothSize.L);
        cloth.setColor(Color.WHITE);

        return cloth;
    }

    private static Food createSampleFood() {
        Food food = new Food();
        food.setName("Banana");
        food.setBrand("Kaufland");
        food.setPrice(1.15);
        food.setExpirationDate(LocalDate.of(2022, 1, 20));

        return food;
    }

    private static Beverage createSampleBeverage() {
        Beverage beverage = new Beverage();
        beverage.setName("Peach drink");
        beverage.setBrand("Cappy");
        beverage.setPrice(2.50);
        beverage.setExpirationDate(LocalDate.of(2022, 1, 19));

        return beverage;
    }

    private static Appliance createSampleAppliance() {
        Appliance appliance = new Appliance();
        appliance.setName("Gaming PC");
        appliance.setBrand("DELL");
        appliance.setPrice(2199.99);
        appliance.setModel("Omicron");
        appliance.setWeight(BigDecimal.valueOf(1.125));
        appliance.setProductionDate(LocalDate.of(2021, 4, 26));

        return appliance;
    }
}
