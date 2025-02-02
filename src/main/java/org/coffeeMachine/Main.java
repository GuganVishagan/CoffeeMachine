package org.coffeeMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.displayCoffee();
        System.out.println();
        coffeeMachine.displayInventory();
        System.out.println();
        coffeeMachine.orderCoffee("espresso", 300);
        System.out.println();
        coffeeMachine.displayInventory();


    }
}