import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecipesMenu {

    // RECIPES MENU
    public static void runRecipesMenu(Recipes recipes, Scanner scanner) {
        boolean recipesRunning = true;
        int choice;

        while (recipesRunning) {
            printRecipesOptions();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                choice = -1;
                scanner.nextLine();
            }

            switch (choice) {
                case 0:
                    System.out.printf("Quitting  Menu");
                    recipesRunning = false;
                    break;
                case 1:
                    printRecipes(recipes);

                    break;
                case 2:
                    newRecipe(recipes, scanner);

                    break;
                case 3:
                    removeRecipe(recipes, scanner);

                    break;
                case 4:

                    RecipeEditorMenu.runRecipeEditorMenuMenu(recipes,scanner);
                    break;
                default:
                    System.out.printf("Invalid choice.");
            }
            System.out.printf("%n");
        }
    }
    
    // RECIPES
    public static void printRecipesOptions() {
        String label = "printRecipesOptions";
        System.out.printf("[%s] Pick an option [0-3]. %n", label);
        System.out.printf("[%s] 0 ) Quit Recipes Menu%n", label);
        System.out.printf("[%s] 1 ) Print Recipes %n", label);
        System.out.printf("[%s] 2 ) Add New Recipe %n", label);
        System.out.printf("[%s] 3 ) Remove Recipe %n", label);
        System.out.printf("[%s] 4 ) Edit Recipe %n", label);
        System.out.printf("[%s] %n",label);
    }

    // SAVING / LOADING
    public static void saveRecipes(Recipes recipes) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("recipes.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(recipes);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.printf("[saveRecipes] Writing recipes. %n");
        } catch (IOException e) {
            System.out.printf("[saveRecipes] error: %s%n", e);
        }
    }

    public static Recipes loadRecipes(Recipes recipes) {
        try {
            FileInputStream fileInputStream = new FileInputStream("recipes.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            recipes = (Recipes) objectInputStream.readObject();
            objectInputStream.close();
            System.out.printf("[loadRecipes] Loading recipes. %n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("[loadRecipes] error: %s%n", e);
        }

        return recipes;
    }

    // New / Remove
    public static void newRecipe(Recipes recipes, Scanner scanner) {
        String title = "";

        System.out.printf("[newRecipe] What is the recipe's title you want to add?%n");
        title = scanner.nextLine();

        Recipe recipe = new Recipe(title);

        if (!recipes.getRecipes().containsKey(recipe.getTitle())) {
            recipes.addRecipe(recipe);
            saveRecipes(recipes);
            System.out.printf("[newRecipe] Addeded %s to Recipe class.%n", recipe.getTitle());
        } else {
            System.out.printf("[newRecipe] Recipe already added.%n");
        }
    }

    public static void removeRecipe(Recipes recipes, Scanner scanner) {
        printRecipes(recipes);

        String name = "";

        System.out.printf("[removeRecipe] What is the recipe's name you want to remove?%n");
        name = scanner.nextLine();

        Recipe recipe = new Recipe(name);

        if (recipes.getRecipes().containsKey(recipe.getTitle())) {
            recipes.removeRecipe(recipe);
            // save test
            saveRecipes(recipes);
            System.out.printf("[removeRecipe] Removed %s from Recipe class.%n", recipe.getTitle());
        } else {
            System.out.printf("[removeRecipe] recipe not found.%n");
        }
    }

    // Print
    public static void printRecipes(Recipes recipes) {
        System.out.printf("[printRecipes] Current Recipes: %n");
        for (HashMap.Entry<String, Recipe> entry : recipes.getRecipes().entrySet()) {
            System.out.printf("[printRecipes] %s.%n", entry.getKey());
        }
        System.out.printf("[printRecipes] %n");
    }

}