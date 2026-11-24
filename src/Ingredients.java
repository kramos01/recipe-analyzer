import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Ingredients extends Object implements Serializable {
    protected List<Ingredient> ingredients;

    public Ingredients(){
        ingredients = new ArrayList<>();
    }

    // getters
    public List<Ingredient> getIngredients(){ return ingredients;}
    public void setIngredients(List<Ingredient> ingredients){this.ingredients=ingredients;}
    public void addIngredient(Ingredient ingredient){ingredients.add(ingredient);}
    public void removeIngredient(Ingredient ingredient){ingredients.remove(ingredient);}
}