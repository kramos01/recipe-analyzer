package Ingredients;
import java.util.InputMismatchException;
import java.util.Scanner;

// used to edit a ingredient's data
public class IngredientEditorMenu {

    public IngredientEditorMenu() {

    }

    // IngredientEditorMenu MENU
    public static void runIngredientEditorMenu(Ingredients ingredients, Scanner scanner) {
        int choice;
        // show choices
        IngredientsMenu.printIngredients(ingredients);
        System.out.printf("What ingredient do you want to edit.%n");
        String name = "";
        try {
            name = scanner.nextLine();
        } catch (Exception e) {

            scanner.nextLine();
        }

        // check if ingredient exists
        if (ingredients.getIngredients().containsKey(name)) {
            Boolean editingIngredient = true;
            while (editingIngredient) {
                printIngredientEditorOptions();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    choice = -1;
                    scanner.nextLine();
                }

                switch (choice) {
                    case 0:
                        System.out.printf("Quitting Ingredient Editor.");
                        editingIngredient = false;
                        break;
                    case 1:
                        // set name
                        name = setName(ingredients, scanner, name);
                        
                        break;
                    case 2:
                        // set
                        break;
           
                    default:
                        System.out.printf("Invalid choice.");
                }
                System.out.printf("%n");
            }
        } else {
            System.out.printf("[setName] Ingredient not found.%n");
        }
    }

    // INDIVIDUAL RECIPE
    public static void printIngredientEditorOptions() {

        String label = "printIngredientEditorOptions";
        System.out.printf("[%s] Pick an option [0-9]. %n", label);
        System.out.printf("[%s] 0 ) Quit Ingredient Editor%n", label);
        System.out.printf("[%s] 1 ) Set Name%n", label);
        System.out.printf("[%s] 2 ) foobar%n", label);
        System.out.printf("[%s] %n", label);
    }

    public static String setName(Ingredients ingredients, Scanner scanner, String name) {

        System.out.printf("[setName] What is the ingredient's name you want to add?%n");
        String newName = scanner.nextLine();
        Ingredient ingredient = ingredients.getIngredients().remove(name);
        
        ingredient.setName(newName);

        ingredients.getIngredients().put(newName,ingredient);

        IngredientsMenu.saveIngredients(ingredients);

        System.out.printf("[setName] Changed ingredient name from %s to %s.%n", name, newName);
        return newName;
    }
}