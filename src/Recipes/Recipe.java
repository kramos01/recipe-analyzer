package Recipes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recipe extends Object implements Serializable {
    protected String title;
    protected int servings;
    protected int prepTime;
    protected int cookTime;
    protected HashMap<String,Integer> ingredients;
    protected List<String> steps;
    
    public Recipe(String title){
        this.title=title;
        ingredients = new HashMap<>();
        steps = new ArrayList<>();
    }

    public String getTitle(){return title;}
    public int getServings(){return servings;}
    public int getPrepTime(){return prepTime;}
    public int getCookTime(){return cookTime;}
    public List<String> getSteps(){return steps;}
   
    public HashMap<String,Integer> getIngredients() {return ingredients;}

    public void setTitle(String title){this.title=title;}
    public void setServings(int servings){this.servings=servings;}
    public void setPrepTime(int prepTime){this.prepTime=prepTime;}
    public void setCookTime(int cookTime){this.cookTime=cookTime;}
    public void addIngredient(String ingredientName,int amount){ingredients.put(ingredientName,amount);}
    public void removeIngredient(String ingredientName){ingredients.remove(ingredientName);}
    public void addStep(String step){steps.add(step);}
    public void removeStep(String step){steps.remove(step);}
    public void editStep(Integer index,String step){steps.set(index, step);}
}