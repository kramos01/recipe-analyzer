import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;

public class Ingredients extends Object implements Serializable {
    //This is the ingredients class. it gets serialized into ingredients.txt
    protected HashMap<String,Ingredient> ingredients;
    public Ingredients(){
        ingredients = new HashMap<>();
    }

    // getters
    public HashMap<String,Ingredient>  getIngredients(){ return ingredients;}
    public void setIngredients(HashMap<String,Ingredient>  ingredients){this.ingredients=ingredients;}
    public void addIngredient(Ingredient ingredient){ingredients.put(ingredient.getName(),ingredient);}
    public void removeIngredient(Ingredient ingredient){ingredients.remove(ingredient.getName());}
}