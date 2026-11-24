import java.io.Serializable;
public class TimeInfo extends Object implements Serializable {
    protected int prepTimeMinutes;
    protected int cookTimeMinutes;
    protected int totalTimeMinutes;
      // instantiated
    public TimeInfo(int prepTimeMinutes,int cookTimeMinutes){
        this.prepTimeMinutes=prepTimeMinutes;
        this.cookTimeMinutes=cookTimeMinutes;
        this.totalTimeMinutes=prepTimeMinutes+cookTimeMinutes;
    }

    public int getPrepTimeMinutes(){return prepTimeMinutes;}
    public int getCookTimeMinutes(){return cookTimeMinutes;}
    public int getPrepTotalMinutes(){return totalTimeMinutes;}

    public void setPrepTimeMinutes(int prepTimeMinutes){this.prepTimeMinutes=prepTimeMinutes;}
    public void setCookTimeMinutes(int cookTimeMinutes){this.cookTimeMinutes=cookTimeMinutes;}
    public void setTotalTimeMinutes(){this.totalTimeMinutes=prepTimeMinutes+cookTimeMinutes;}
}
