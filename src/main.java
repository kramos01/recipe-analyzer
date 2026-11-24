import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredients(loadIngredients(ingredients).getIngredients());
        
    
        for(Ingredient i: ingredients.getIngredients()){
            System.out.printf("[main] Ingredient: %s.%n",i.getName());
        }
        //  String input = "Orange";
        // Ingredient ingredient = new Ingredient(input);
        // // test
        // if(!ingredients.getIngredients().contains(ingredient)){
        //     ingredients.addIngredient(ingredient);
        //     // save test
        //     saveIngredients(ingredients);
        //     System.out.printf("[main] Addeded %s to Ingredient class.%n",ingredient.getName());
        // } else {
        //     System.out.printf("[main] Do nothing.%n");
        // }

      
       


        

    }
    public static void saveIngredients(Ingredients ingredients){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ingredients.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ingredients);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.printf("[saveIngredients] Writing ingredients. %n");
        } catch (IOException e) {
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
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.printf("[loadIngredients] error: %s%n",e);
          
        }

        return ingredients;
    }

      // create new person
    public static Ingredient newIngredient(){
        String name = "";

        Scanner scanner = new Scanner(System.in);
        System.out.printf("[newIngredient] What is the ingredients name?%n");
        name = scanner.nextLine();
        scanner.close();

        return new Ingredient(name);
    }


}