package Recipes;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// used to edit an individual recipe's data
public class RecipeEditorMenu {

    // RecipeEditorMenu MENU
    public static void runRecipeEditorMenuMenu(Recipes recipes, Scanner scanner) {
        String label = "runRecipeEditorMenuMenu";
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
                printRecipeEditorOptions(recipes, scanner, title);
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    choice = -1;
                    scanner.nextLine();
                }

                switch (choice) {
                    case 0:
                        System.out.printf("[%s] Quitting Recipe Editor.", label);
                        editingRecipe = false;
                        break;
                    case 1:
                        // set title
                        title = setTitle(recipes, scanner, title);

                        break;
                    case 2:
                        setTimes(recipes, scanner, title);

                        break;
                    case 3:
                        // list ingredients
                        printIngredients(recipes, scanner, title);
                        break;
                    case 4:
                        // add ingredients
                        addIngredient(recipes, scanner, title);
                        break;
                    case 5:
                        // remove ingredients
                        removeIngredient(recipes, scanner, title);
                        break;
                    case 6:
                        // list steps
                        printSteps(recipes, scanner, title);
                        break;
                    case 7:
                        // add step
                        addStep(recipes, scanner, title);
                        break;
                    case 8:
                        // remove step
                        removeStep(recipes, scanner, title);
                        break;
                    case 9:
                        // edit step
                        editStep(recipes, scanner, title);
                        break;
                      case 10:
                        // edit step
                        editStep(recipes, scanner, title);
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
    public static void printRecipeEditorOptions(Recipes recipes, Scanner scanner, String title) {
        printRecipe(recipes, scanner, title);
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
        System.out.printf("[%s] 10 ) Set Serving %n", label);

        System.out.printf("[%s] %n", label);
    }

    public static void printRecipe(Recipes recipes, Scanner scanner, String title) {
        String label = "printRecipe";
        RecipesMenu.printRecipes(recipes);

        // check if recipe exists
        if (recipes.getRecipes().containsKey(title)) {
            Recipe recipe = recipes.getRecipes().get(title);
            System.out.printf("[%s] Title: %s%n", label, recipe.getTitle());

            System.out.printf("[%s] Prep Time: %d%n", label, recipe.getPrepTime());
            System.out.printf("[%s] Cook Time: %d%n", label, recipe.getCookTime());

            int totalTime = recipe.getPrepTime() + recipe.getCookTime();
            System.out.printf("[%s] Total Time: %d%n", label, totalTime);
            
            System.out.printf("[printRecipes] Current Ingredients: %n");
            for (HashMap.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
                System.out.printf("[printRecipes] %s %d.%n", entry.getKey(),entry.getValue());
            }

            System.out.printf("[%s] Steps:%n", label);
            for (String step : recipe.getSteps()) {
                System.out.printf("[%s] %s %n", label,step);
            }

            System.out.printf("[%s] %n", label);
        } else {
            System.out.printf("[%s] Recipe not found.%n", label);

        }
    }

    public static String setTitle(Recipes recipes, Scanner scanner, String title) {

        System.out.printf("[setTitle] What is the recipe's title you want to add?%n");
        String newTitle = scanner.nextLine();
        Recipe recipe = recipes.getRecipes().remove(title);

        recipe.setTitle(newTitle);

        recipes.getRecipes().put(newTitle, recipe);

        RecipesMenu.saveRecipes(recipes);

        System.out.printf("[setTitle] Changed recipe name from %s to %s.%n", title, newTitle);
        return newTitle;
    }


    public static void setTimes(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        int prepTime = recipe.getPrepTime();
        int cookTime = recipe.getCookTime();
        int oldPrepTime = prepTime;
        int oldCookTime = cookTime;
        // set timing
        String label = "setTimes";
        try {
            System.out.printf("[%s] What is the prep time you want to set?%n", label);
            System.out.printf("[%s] Current prep time: [%d]%n", label, prepTime);

            prepTime = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }
        try {
            System.out.printf("[%s] What is the cook time you want to set?%n", label);
            System.out.printf("[%s] Current cook time: [%d]%n", label, cookTime);
            cookTime = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s] Not an integer. Input a number.%n", label);
        }

        recipes.getRecipes().remove(title);

        recipe.setPrepTime(prepTime);
        recipe.setCookTime(cookTime);

        recipes.getRecipes().put(title, recipe);

        RecipesMenu.saveRecipes(recipes);

        System.out.printf("[setTitle] Changed %s's prep time: %d -> %d - cook time: %d -> %d.%n", title, oldPrepTime,
                prepTime,
                oldCookTime, cookTime);

    }

    public static void printIngredients(Recipes recipes, Scanner scanner, String title) {
        String label = "printIngredients";
        Recipe recipe = recipes.getRecipes().get(title);
        for (HashMap.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
            System.out.printf("[%s] %s.%n", label, entry.getKey());
        }
    }

    public static void printSteps(Recipes recipes, Scanner scanner, String title) {
        String label = "printSteps";
        Recipe recipe = recipes.getRecipes().get(title);
        for (String s : recipe.getSteps()) {
            System.out.printf("[%s] %s.%n", label, s);
        }
    }

    public static void addIngredient(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        String ingredientName = "";
        int amount = 0;
        // set timing
        String label = "addIngredient";
        try {
            System.out.printf("[%s] What ingredient do you want to add?%n", label);

            ingredientName = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }

        try {
            System.out.printf("[%s] How much are you using?%n", label);

            amount = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s] Not an integer. Input a number.%n", label);
        }

      
            recipes.getRecipes().remove(title);
            recipe.addIngredient(ingredientName, amount);

            recipes.getRecipes().put(title, recipe);

            RecipesMenu.saveRecipes(recipes);

            System.out.printf("[%s] Added %s %d to %s%n", label, ingredientName, amount, title);
      

    }

    public static void removeIngredient(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        String ingredientName = "";
        int amount = 0;
        // set timing
        String label = "addIngredient";
        try {
            System.out.printf("[%s] What ingredient do you want to add?%n", label);

            ingredientName = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }

        if (recipe.getIngredients().containsKey(ingredientName)) {
            recipe.removeIngredient(ingredientName);
            recipes.getRecipes().remove(title);

            RecipesMenu.saveRecipes(recipes);

            System.out.printf("[%s] Removed %s from %s%n", label, ingredientName, title);
        } else {
            System.out.printf("[%s] %s not found in %s%n", label, ingredientName, title);
        }

    }

    public static void addStep(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        String step = "";

        // set timing
        String label = "addStep";

        System.out.printf("[%s] What step do you want to add?%n", label);

        step = scanner.nextLine();

        recipes.getRecipes().remove(title);
        recipe.addStep(step);

        recipes.getRecipes().put(title, recipe);

        RecipesMenu.saveRecipes(recipes);

        System.out.printf("[%s] Added %s to %s%n", label, step, title);

    }

    public static void removeStep(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        int index = 0;

        // set timing
        String label = "removeStep";
        try {
            System.out.printf("[%s] What step do you want to remove?%n", label);

            index = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }
        if (recipe.getSteps().contains(index)) {
            recipe.getSteps().remove(index);
            recipes.getRecipes().remove(title);

            RecipesMenu.saveRecipes(recipes);

            System.out.printf("[%s] Removed %d from %s%n", label, index, title);
        } else {
            System.out.printf("[%s] Index not found for %s%n", label, title);
        }

    }

    public static void editStep(Recipes recipes, Scanner scanner, String title) {
        Recipe recipe = recipes.getRecipes().get(title);
        int index = 0;

        // set timing
        String label = "removeStep";
        try {
            System.out.printf("[%s] What step do you want to remove?%n", label);

            index = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }
        if (recipe.getSteps().contains(index)) {
            recipe.getSteps().remove(index);
            recipes.getRecipes().remove(title);

            RecipesMenu.saveRecipes(recipes);

            System.out.printf("[%s] Removed %d from %s%n", label, index, title);
        } else {
            System.out.printf("[%s] Index not found for %s%n", label, title);
        }

    }

    public static void setServing(Recipes recipes, Scanner scanner, String title) {

        Recipe recipe = recipes.getRecipes().get(title);
        int servings = recipe.getServings();

        int oldServings = servings;

        // set timing
        String label = "setServings";
        try {
            System.out.printf("[%s] What is the servings you want to set?%n", label);
            System.out.printf("[%s] Current servings: [%d]%n", label, servings);

            servings = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("[%s]  Not an integer. Input a number.%n", label);
        }
        

        recipes.getRecipes().remove(title);

        recipe.setServings(servings);
     

        recipes.getRecipes().put(title, recipe);

        RecipesMenu.saveRecipes(recipes);

        System.out.printf("[setTitle] Changed %s's servings: %d -> %d.%n", title, oldServings,
                servings);

    }

    
}