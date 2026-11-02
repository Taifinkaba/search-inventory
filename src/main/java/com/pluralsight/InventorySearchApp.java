package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventorySearchApp {


    public static void main(String[] args) {

        ArrayList<Product> products = InventorySearchApp.getInventory();

        System.out.println("We carry the following inventory: ");

        // display each product
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

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {

            // skip the header
            bufferedReader.readLine();

            String input;

            // read each line
            while ((input = bufferedReader.readLine()) != null) {

                // skip empty lines
                if (input.trim().equals("")) continue;

                // split the line
                String[] parts = input.split("\\|");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                // create product and add to list
                Product product = new Product(id, name, price);
                inventory.add(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory, try again!");
        }

        return inventory;
    }

}