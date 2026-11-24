import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredients(loadIngredients(ingredients).getIngredients());

        while (running) {
            printOptions();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                choice = -1;
                scanner.nextLine();
            }

            switch (choice) {
                case 0:
                    System.out.printf("Quitting");
                    running = false;
                    break;
                case 1:
                    runIngredientsMenu(ingredients, scanner);
                    break;
                case 2:
                    System.out.printf("Foo");

                    break;
                case 3:
                    System.out.printf("Foobar");

                    break;
                default:
                    System.out.printf("Invalid choice.");
            }
            System.out.printf("%n");
        }
        scanner.close();
    }

    public static void printOptions() {
        System.out.printf("[printOptions] Pick an option [0-3]. %n");
        System.out.printf("[printOptions] 0 ) Quit %n");
        System.out.printf("[printOptions] 1 ) Ingredients Menu%n");
        System.out.printf("[printOptions] 2 ) foo%n");
        System.out.printf("[printOptions] 3 ) foobar%n");
        System.out.printf("[printOptions] %n");
    }

    // INGREDIENTS MENU
    public static void runIngredientsMenu(Ingredients ingredients, Scanner scanner) {
        boolean ingredientsRunning = true;
        int choice;

        while (ingredientsRunning) {
            printIngredientsOptions();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                choice = -1;
                scanner.nextLine();
            }

            switch (choice) {
                case 0:
                    System.out.printf("Quitting Ingredients Menu");
                    ingredientsRunning = false;
                    break;
                case 1:
                    printIngredients(ingredients);

                    break;
                case 2:
                    newIngredient(ingredients, scanner);

                    break;
                case 3:
                    removeIngredient(ingredients, scanner);

                    break;
                default:
                    System.out.printf("Invalid choice.");
            }
            System.out.printf("%n");
        }
    }

    public static void printIngredientsOptions() {
        System.out.printf("[printIngredientsOptions] Pick an option [0-3]. %n");
        System.out.printf("[printIngredientsOptions] 0 ) Quit Ingredients%n");
        System.out.printf("[printIngredientsOptions] 1 ) Print Ingredients %n");
        System.out.printf("[printIngredientsOptions] 2 ) Add New Ingredient %n");
        System.out.printf("[printIngredientsOptions] 3 ) Remove Ingredient %n");
        System.out.printf("[printIngredientsOptions] %n");
    }

    // SAVING / LOADING
    public static void saveIngredients(Ingredients ingredients) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ingredients.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ingredients);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.printf("[saveIngredients] Writing ingredients. %n");
        } catch (IOException e) {
            System.out.printf("[saveIngredients] error: %s%n", e);
        }
    }

    public static Ingredients loadIngredients(Ingredients ingredients) {
        try {
            FileInputStream fileInputStream = new FileInputStream("ingredients.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ingredients = (Ingredients) objectInputStream.readObject();
            objectInputStream.close();
            System.out.printf("[loadIngredients] Loading ingredients. %n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("[loadIngredients] error: %s%n", e);
        }

        return ingredients;
    }

    // New / Remove
    public static void newIngredient(Ingredients ingredients, Scanner scanner) {
        String name = "";

        System.out.printf("[newIngredient] What is the ingredient's name you want to add?%n");
        name = scanner.nextLine();

        Ingredient ingredient = new Ingredient(name);

        if (!ingredients.getIngredients().containsKey(ingredient.getName())) {
            ingredients.addIngredient(ingredient);
            saveIngredients(ingredients);
            System.out.printf("[newIngredient] Addeded %s to Ingredient class.%n", ingredient.getName());
        } else {
            System.out.printf("[newIngredient] Ingredient already added.%n");
        }
    }

    public static void removeIngredient(Ingredients ingredients, Scanner scanner) {
        printIngredients(ingredients);

        String name = "";

        System.out.printf("[removeIngredient] What is the ingredient's name you want to remove?%n");
        name = scanner.nextLine();

        Ingredient ingredient = new Ingredient(name);

        if (ingredients.getIngredients().containsKey(ingredient.getName())) {
            ingredients.removeIngredient(ingredient);
            // save test
            saveIngredients(ingredients);
            System.out.printf("[removeIngredient] Removed %s from Ingredient class.%n", ingredient.getName());
        } else {
            System.out.printf("[removeIngredient] Ingredient not found.%n");
        }
    }

    // Print
    public static void printIngredients(Ingredients ingredients) {
        System.out.printf("[printIngredients] Current Ingredients: %n");
        for (HashMap.Entry<String, Ingredient> entry : ingredients.getIngredients().entrySet()) {
            System.out.printf("[printIngredients] %s.%n", entry.getKey());
        }
        System.out.printf("[printIngredients] %n");
    }

}