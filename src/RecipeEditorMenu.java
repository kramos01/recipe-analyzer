import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// used to edit a recipe's data
public class RecipeEditorMenu {

    public RecipeEditorMenu() {

    }

    // RecipeEditorMenu MENU
    public static void runRecipeEditorMenuMenu(Recipes recipes, Scanner scanner) {
        int choice;
        // show choices
        RecipesMenu.printRecipes(recipes);
        System.out.printf("What recipe do you want to edit.%n");
        String title = "";
        try {
            title = scanner.nextLine();
        } catch (Exception e) {

            scanner.nextLine();
        }

        // check if recipe exists
        if (recipes.getRecipes().containsKey(title)) {
            Boolean editingRecipe = true;
            while (editingRecipe) {
                printRecipeEditorOptions();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    choice = -1;
                    scanner.nextLine();
                }

                switch (choice) {
                    case 0:
                        System.out.printf("Quitting Recipe Editor.");
                        editingRecipe = false;
                        break;
                    case 1:
                        // set title
                        title = setTitle(recipes, scanner, title);
                        
                        break;
                    case 2:
                        // set timing
                        break;
                    case 3:
                        // list ingredients
                        break;
                    case 4:
                        // add ingredients
                        break;
                    case 5:
                        // remove ingredients
                        break;
                    case 6:
                        // list steps
                        break;
                    case 7:
                        // add step
                        break;
                    case 8:
                        // remove step
                        break;
                    case 9:
                        // edit step
                        break;

                    default:
                        System.out.printf("Invalid choice.");
                }
                System.out.printf("%n");
            }
        } else {
            System.out.printf("[setTitle] Recipe not found.%n");
        }
    }

    // INDIVIDUAL RECIPE
    public static void printRecipeEditorOptions() {

        String label = "printRecipeEditorOptions";
        System.out.printf("[%s] Pick an option [0-9]. %n", label);
        System.out.printf("[%s] 0 ) Quit Recipe Editor%n", label);
        System.out.printf("[%s] 1 ) Set Title %n", label);
        System.out.printf("[%s] 2 ) Set Timing %n", label);
        System.out.printf("[%s] 3 ) List Ingredients %n", label);
        System.out.printf("[%s] 4 ) Add Ingredient %n", label);
        System.out.printf("[%s] 5 ) Remove Ingredient %n", label);
        System.out.printf("[%s] 6 ) List Steps %n", label);
        System.out.printf("[%s] 7 ) Add Step %n", label);
        System.out.printf("[%s] 8 ) Remove Step %n", label);
        System.out.printf("[%s] 9 ) Edit Step %n", label);
        System.out.printf("[%s] %n", label);
    }

    public static String setTitle(Recipes recipes, Scanner scanner, String title) {
  

        System.out.printf("[setTitle] What is the recipe's title you want to add?%n");
        String newTitle = scanner.nextLine();
        Recipe recipe = recipes.getRecipes().remove(title);
        
        recipe.setTitle(newTitle);

        recipes.getRecipes().put(newTitle,recipe);

        RecipesMenu.saveRecipes(recipes);

        System.out.printf("[setTitle] Changed recipe name from %s to %s.%n", title, newTitle);
        return newTitle;
    }
}