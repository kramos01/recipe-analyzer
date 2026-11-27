// change it so recipes store the ingredients
import java.util.InputMismatchException;
import java.util.Scanner;


import Recipes.Recipes;
import Recipes.RecipesMenu;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;

        Recipes recipes = new Recipes();
        recipes.setRecipes(RecipesMenu.loadRecipes(recipes).getRecipes());

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
                    RecipesMenu.runRecipesMenu(recipes, scanner);

                    break;
                case 2:
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
        System.out.printf("[printOptions] 1 ) Recipes Menu%n");
        System.out.printf("[printOptions] 2 ) foobar%n");
        System.out.printf("[printOptions] %n");
    }

   
}