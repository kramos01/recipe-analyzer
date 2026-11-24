import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        Ingredients ingredients = new Ingredients();

        ingredients.setIngredients(loadIngredients(ingredients).getIngredients());

        printIngredients(ingredients);

        // test

    }

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

    // save slot machine
    public static Ingredients loadIngredients(Ingredients ingredients) {
        try {
            // load
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

    // create new person
    public static void newIngredient(Ingredients ingredients) {
        String name = "";

        Scanner scanner = new Scanner(System.in);
        System.out.printf("[newIngredient] What is the ingredient's name you want to add?%n");
        name = scanner.nextLine();
        scanner.close();
        Ingredient ingredient = new Ingredient(name);

        if (!ingredients.getIngredients().containsKey(ingredient.getName())) {
            ingredients.addIngredient(ingredient);
            // save test
            saveIngredients(ingredients);
            System.out.printf("[newIngredient] Addeded %s to Ingredient class.%n", ingredient.getName());
        } else {
            System.out.printf("[newIngredient] Ingredient already added.%n");
        }
    }

    public static void removeIngredient(Ingredients ingredients) {
        printIngredients(ingredients);

        String name = "";

        Scanner scanner = new Scanner(System.in);
        System.out.printf("[removeIngredient] What is the ingredient's name you want to remove?%n");
        name = scanner.nextLine();
        scanner.close();
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

    public static void printIngredients(Ingredients ingredients) {
        System.out.printf("[printIngredients] Current Ingredients: %n");
        for (HashMap.Entry<String, Ingredient> entry : ingredients.getIngredients().entrySet()) {
            System.out.printf("[printIngredients] %s.%n", entry.getKey());
        }
    }

}