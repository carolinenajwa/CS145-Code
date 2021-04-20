
// grab stuff we need
import java.awt.*;
import java.util.*;

public class Orca extends Critter {
    // count helps us keep track of our iterations
    private int count;
    private String lastMove;
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
        

        if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;
            this.lastMove = "IF";
        } else if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;
            this.lastMove = "H";
        }else {
            
            move = Action.RIGHT;
            this.lastMove = "L";
        }

        return move;
    }

    // return gray color
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
        setColor = Color.decode(colorCode);
       
        //setColor = Color.RED;
        this.count++;

        return setColor;
    }   

    // define the UI element of the critter
    public String toString() {

        return "WCC";

    }

}
