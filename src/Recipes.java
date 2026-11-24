import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;

public class Recipes extends Object implements Serializable {
    //This is the recipes class. it gets serialized into recipes.txt
    protected HashMap<String,Recipe> recipes;
    public Recipes(){
        recipes = new HashMap<>();
    }

    // getters
    public HashMap<String,Recipe>  getRecipes(){ return recipes;}
    public void setRecipes(HashMap<String,Recipe>  recipes){this.recipes=recipes;}
    public void addRecipe(Recipe recipe){recipes.put(recipe.getTitle(),recipe);}
    public void removeRecipe(Recipe recipe){recipes.remove(recipe.getTitle());}
}