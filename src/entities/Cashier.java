package entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Cashier {
    private double totalProductsSum = 0.0;
    private double discountSum = 0.0;

    public Cashier() {
    }

    public void printReceipt(List<BaseEntity> products, LocalDateTime purchaseDateTime) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("Date: %s%n", dateFormat.format(purchaseDateTime));
        System.out.println("---Products---\n");

        for (BaseEntity p : products) {
            int quantity = new Random().nextInt(1, 5);
            double productTotal = quantity * p.getPrice();

            System.out.printf("%s - %s\n",
                    p.getName(),
                    p.getBrand()
            );
            System.out.printf(
                    "%d x $%.2f = $%.2f\n",
                    quantity,
                    p.getPrice(),
                    productTotal
            );
            LocalDate expDate;
            switch (p.getClass().getSimpleName()) {
                case "Food" -> {
                    Food food = (Food) p;
                    expDate = food.getExpirationDate();
                    this.totalProductsSum += calculateTotal(purchaseDateTime, productTotal, expDate);
                }
                case "Beverage" -> {
                    Beverage beverage = (Beverage) p;
                    expDate = beverage.getExpirationDate();
                    this.totalProductsSum += calculateTotal(purchaseDateTime, productTotal, expDate);
                }
                case "Cloth" -> {
                    if (purchaseDateTime.getDayOfWeek() != DayOfWeek.SATURDAY
                            && purchaseDateTime.getDayOfWeek() != DayOfWeek.SUNDAY) {
                        System.out.printf("#discount 10%% -%.2f\n", productTotal * 0.10);
                        this.totalProductsSum += productTotal - (productTotal * 0.10);
                        discountSum += productTotal * 0.10;
                    } else {
                        this.totalProductsSum += productTotal;
                    }
                }
                case "Appliance" -> {
                    if (purchaseDateTime.getDayOfWeek() == DayOfWeek.SATURDAY && productTotal > 999
                            || purchaseDateTime.getDayOfWeek() == DayOfWeek.SUNDAY && productTotal > 999) {
                        this.totalProductsSum += productTotal - (productTotal * 0.05);
                        this.discountSum += productTotal * 0.05;
                        System.out.printf("#discount 5%% -%.2f\n", productTotal * 0.05);
                    }
                    else {
                        this.totalProductsSum += productTotal;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("=============================\n");
        System.out.printf("SUBTOTAL: $%.2f\n", this.totalProductsSum);
        System.out.printf("DISCOUNT: -$%.2f\n\n", this.discountSum);
        System.out.printf("TOTAL: $%.2f", this.totalProductsSum - this.discountSum);
    }

    private double calculateTotal(LocalDateTime purchaseDateTime, double productTotal, LocalDate expDate) {
        double totalSum = 0.0;
        if (purchaseDateTime.getDayOfYear() < expDate.getDayOfYear()
                && purchaseDateTime.getDayOfMonth() >= expDate.getDayOfMonth() - 5) {
            totalSum += (productTotal - (productTotal * 0.10));
            this.discountSum += productTotal * 0.10;
            System.out.printf("#discount 10%% -%.2f\n", productTotal * 0.10);

        } else if (expDate.toString().equals(purchaseDateTime.toLocalDate().toString())) {
            totalSum += (productTotal - (productTotal * 0.50));
            this.discountSum += productTotal * 0.50;
            System.out.printf("#discount 50%% -%.2f\n", productTotal * 0.50);
        } else {
            totalSum += productTotal;
        }
        return totalSum;
    }
}
