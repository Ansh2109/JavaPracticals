package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import discount.DiscountEngine;
import discount.DiscountRule;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> prices = new ArrayList<>();

        prices.add(1000.0);
        prices.add(500.0);
        prices.add(2000.0);
        prices.add(750.0);

        System.out.println("===== DISCOUNT ENGINE =====");

        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. Flat ₹100 Discount");

        System.out.print("Choose discount rule: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        switch (choice) {

            case 1:
                rule = price -> price * 0.90;
                break;

            case 2:
                rule = price -> price * 0.80;
                break;

            case 3:
                rule = price -> price - 100;
                break;

            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        System.out.println("\n===== RESULT =====");

        DiscountEngine.applyDiscount(prices, rule);

        sc.close();
    }
}