import java.io.Serializable;
// uses an ingredient and holds quantity and unit for a recipe
public class RecipeIngredient extends Object implements Serializable {
    protected Ingredient ingredient;
    protected double quantity;
    protected String unit;


    // instantiated
    public RecipeIngredient(Ingredient ingredient,double quantity, String unit){
        this.ingredient=ingredient;
        this.quantity=quantity;
        this.unit=unit;
    }

    // getters
    public Ingredient getIngredient(){return  ingredient;}
    public double getQuantity() {return quantity;}
    public String getUnit(){return unit;}


    public void setIngredient(Ingredient ingredient){this.ingredient=ingredient;}
    public void setQuantity(double quantity){this.quantity=quantity;}
    public void setUnit(String unit){this.unit=unit;}
       


}