
// grab stuff we need
import java.awt.*;
import java.util.*;

public class Orca extends Critter {
    // count helps us keep track of our iterations
    private int count;
    private Random rand;
    private int lastColorCode;

    // Orca class with counter
    public Orca() {
        this.count = 0;
        this.rand = new Random();
    }

    // action movement for Giant
    public Action getMove(CritterInfo info) {
        Action move;
        if (info.getFront() == Neighbor.EMPTY) {
            move =  Action.HOP;
        } else {

            if (info.getFront() == Neighbor.OTHER) {
                move = Action.INFECT;
            }else{
                move = Action.RIGHT;
            }
            

            while(this.rand.nextInt(200) % 2 == 0){
                move = Action.HOP;
            }

            
        }

        return move;
    }

    // return a color
    public Color getColor() {
        Color setColor;
        int randColorInt;

        //we can check if this.lastColorCode is initalized becase we are
        //adding 1 in the next step
        if (this.lastColorCode == 0) {
            randColorInt = this.rand.nextInt(0xffffff + 1);
        }else{
            randColorInt = this.lastColorCode + 1;
        }
        
        //format into hex code. 
        String colorCode = String.format("#%06x", randColorInt);

        //return the color
        setColor = Color.decode(colorCode);

        //return the color code
        return setColor;
    }   

    // define the UI element of the critter
    public String toString() {
        String name;

        if (this.count % 3 == 0) {
            name = "WCC";
        } else {
            name = "ROCKS";
        }

        this.count++;

        return name;

    }

}
