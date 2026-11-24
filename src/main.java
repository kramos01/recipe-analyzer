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
        ingredients.setIngredients(IngredientsMenu.loadIngredients(ingredients).getIngredients());

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
                    IngredientsMenu.runIngredientsMenu(ingredients, scanner);
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

   
}