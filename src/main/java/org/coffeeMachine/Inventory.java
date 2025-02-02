package org.coffeeMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> ingredients;
    private final Map<String, Integer> coffeePrices;

    public Inventory() {
        this.ingredients = new HashMap<>();
        this.coffeePrices = new HashMap<>();
        this.ingredients.put("Coffee Beans", 1000);
        this.ingredients.put("Milk", 500);
        this.ingredients.put("Cream", 100);
        this.ingredients.put("Water", 1000);
        this.ingredients.put("Sugar", 100);
        this.coffeePrices.put("espresso", 100);
        this.coffeePrices.put("latte", 200);
        this.coffeePrices.put("cappuccino", 200);
    }

    public void addIngredient(String ingredient, int quantity) {
        this.ingredients.put(ingredient, quantity);
    }

    public void coffeePayment(String coffeeType, int price) {
        if(coffeePrices.containsKey(coffeeType)) {
            if(coffeePrices.get(coffeeType) < price) {
                System.out.println("Please collect your remaining change : " + (price - coffeePrices.get(coffeeType)));
            }
            else if(coffeePrices.get(coffeeType).equals(price)) {
                System.out.println("Thanks for your coffee payment!");
            }
            else {
                throw new RuntimeException("Your coffee payment was not successful, you have insufficient funds");
            }
        }
    }

    public boolean checkInventory(String ingredient, int quantity) {
        return ((this.ingredients.containsKey(ingredient)) && (this.ingredients.get(ingredient) >= quantity));
    }

    public void useIngredient(String ingredient, int quantity) {
        if(checkInventory(ingredient, quantity)) {
            this.ingredients.put(ingredient, ingredients.get(ingredient) - quantity);
        }
        else {
            System.out.println("Not enough" + ingredient + " in your inventory");
        }

    }

    public void displayInventory() {
        System.out.println("Inventory: ");
        for (Map.Entry<String, Integer> entry : this.ingredients.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayCoffeePrices() {
        System.out.println("Coffee Prices: ");
        for (Map.Entry<String, Integer> entry : this.coffeePrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
