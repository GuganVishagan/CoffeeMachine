package org.coffeeMachine;

public class CoffeeMachine {
    private static CoffeeMachine coffeeMachine;
    private Inventory inventory;
    private CoffeeMachine() {
        inventory = new Inventory();
    }

    public static CoffeeMachine getInstance() {
        if(coffeeMachine == null) {
            return new CoffeeMachine();
        }
        return coffeeMachine;
    }

    public synchronized void orderCoffee(String coffeeType, int price) {
        switch (coffeeType) {
            case "espresso" : {
                if(inventory.checkInventory("Coffee Beans", 2) && inventory.checkInventory("Water", 1)) {
                    inventory.coffeePayment("espresso", 300);
                    inventory.useIngredient("Coffee Beans", 2);
                    inventory.useIngredient("Water", 1);
                    System.out.println("Making your Espresso......");
                    break;
                }
                else {
                    System.out.println("Coffee not available, we are out of stock");
                }
            }
            case "latte" : {
                if(inventory.checkInventory("Coffee Beans", 2) && inventory.checkInventory("Water", 1) && inventory.checkInventory("Milk", 1)) {
                    inventory.coffeePayment("latte", 300);
                    inventory.useIngredient("Coffee Beans", 2);
                    inventory.useIngredient("Water", 1);
                    inventory.useIngredient("Milk", 1);
                    System.out.println("Making your Latte......");
                    break;
                }
                else {
                    System.out.println("Coffee not available, we are out of stock");
                }
            }
            case "cappuccino" : {
                if(inventory.checkInventory("Coffee Beans", 2) && inventory.checkInventory("Water", 1) && inventory.checkInventory("Milk", 1) && inventory.checkInventory("Cream", 1)) {
                    inventory.coffeePayment("latte", 300);
                    inventory.useIngredient("Coffee Beans", 2);
                    inventory.useIngredient("Water", 1);
                    inventory.useIngredient("Milk", 1);
                    inventory.useIngredient("Cream", 1);
                    System.out.println("Making your Cappuccino......");
                    break;
                }
                else {
                    System.out.println("Coffee not available, we are out of stock");
                }
            }
            default : {
                throw new IllegalArgumentException("Invalid coffee type");
            }

        }
    }

    public void displayCoffee() {
        inventory.displayCoffeePrices();
    }

    public void displayInventory() {
        inventory.displayInventory();
    }
}
