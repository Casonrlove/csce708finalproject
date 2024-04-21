/**
 * Emmanuel Tobias Ramirez
 * CSCE 111 Final Project
 * Le Class makes player includes functions to get/change names and points
 */

public class Le {

    // fields
    String name;
    int points;

    // constructor
    public Le(String name, int points){
        this.name = name;
        this.points = points;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    public boolean winner(){
        if (points >= 21) {
            return true;
        } else {
            return false;
        }
    }

    public void addThree(){
        points = points + 3;
    }

    public void addTwo(){
        points = points + 2;
    }
}
