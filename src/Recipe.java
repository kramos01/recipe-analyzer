import java.io.Serializable;
import java.util.List;
public class Recipe extends Object implements Serializable {
    protected String title;
    protected int servings;
    protected TimeInfo timing;
    protected List<RecipeIngredient> ingredients;
    protected List<String> steps;
    
    public Recipe(String title){
        this.title=title;
    }

    public String getTitle(){return title;}
    public int getServings(){return servings;}
    public TimeInfo getTimeInfo(){return timing;}
    public List<RecipeIngredient> getIngredients() {return ingredients;}

    public void setTitle(String title){this.title=title;}
    public void setServings(int servings){this.servings=servings;}
    public void setTimeInfo(TimeInfo timing){this.timing=timing;}
    public void setTitle(List<RecipeIngredient> ingredients){this.ingredients=ingredients;}
    
}