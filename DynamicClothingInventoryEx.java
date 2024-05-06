

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Clothing {
    private String name;
    private double price;
    
    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
}

public class DynamicClothingInventoryEx {
    public static void main(String[] args) {
        // Create an ArrayList to store clothing items
        ArrayList<Clothing> inventory = new ArrayList<>();
        
        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Allow users to add clothing items to the inventory dynamically
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Clothing Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Purchase Item");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add Clothing Item
                        System.out.print("Enter name of the clothing item: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter price of the clothing item: ");
                        double itemPrice = scanner.nextDouble();
                        inventory.add(new Clothing(itemName, itemPrice));
                        System.out.println("Clothing item added successfully!");
                        break;

                    case 2:
                        // Display Inventory
                        System.out.println("\nInventory:");
                        for (Clothing item : inventory) {
                            System.out.println(item.getName() + " - $" + item.getPrice());
                        }
                        break;

                    case 3:
                        // Purchase Item
                        System.out.print("Enter the name of the item you want to purchase: ");
                        String purchaseItem = scanner.nextLine();
                        boolean found = false;
                        for (Clothing item : inventory) {
                            if (item.getName().equalsIgnoreCase(purchaseItem)) {
                                System.out.println("Item found! You have purchased: " + item.getName() + " for $" + item.getPrice());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Sorry, the item is not available in the inventory.");
                        }
                        break;

                    case 4:
                        // Exit
                        System.out.println("Exiting program...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

