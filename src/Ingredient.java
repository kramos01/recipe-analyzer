import java.io.Serializable;
// holds the base for the ingredient stores nutrition data, name and description
public class Ingredient extends Object implements Serializable {
    protected String name;
    protected String description;
    protected Nutrition nutrition;

    // instantiated
    public Ingredient(String name){
        this.name=name;
    }

    // getters
    public String getName(){ return name;}
    public String getDescription(){return description;}
    public Nutrition getNutrition(){return nutrition;}

    public void setName(String name){this.name=name;}
    public void setDescription(String description){this.description=description;}
    public void setNutrition(Nutrition nutrition){this.nutrition=nutrition;}


}