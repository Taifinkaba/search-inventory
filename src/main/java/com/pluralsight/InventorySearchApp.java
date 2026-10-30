package com.pluralsight;

import java.util.ArrayList;

public class InventorySearchApp {


    public static void main(String[] args) {

        ArrayList<Product> products = InventorySearchApp.getInventory();

        System.out.println("We carry the following inventory: ");

        // Display each product
        for (Product p : products) {
            System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(), p.getName(), p.getPrice());
        }
    }

    private static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        // add products to inventory
        inventory.add(new Product(4567, "10' 2x4 (grade B)", 9.99));
        inventory.add(new Product(1234, "Hammer", 19.49));
        inventory.add(new Product(2345, "Box of nails", 9.29));
        inventory.add(new Product(8888, "Screwdriver Set", 24.50));
        inventory.add(new Product(7777, "Power Drill", 89.99));
        inventory.add(new Product(1111, "Paint Brush", 4.99));
        inventory.add(new Product(2222, "Roll of Tape", 3.50));
        inventory.add(new Product(3333, "Level", 15.00));
        inventory.add(new Product(4444, "Measuring Tape", 12.75));
        inventory.add(new Product(5555, "Work Gloves", 18.25));

        return inventory;
    }

}