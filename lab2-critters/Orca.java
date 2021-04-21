//The Orca Class. This displays as WCC/ROCKS alternately. 
//The color is generated randomly the first time, then the 
//previous critter's color is return and incremented slightly. 
//The color is not random after the first turn. 

// grab stuff we need
import java.awt.*;
import java.util.*;

public class Orca extends Critter {
    // count helps us keep track of our iterations
    private int count;
    // random number generator
    private Random rand;
    // keep track of the last color code
    private int lastColorCode;

    // Orca class with counter
    public Orca() {
        this.count = 0;
        this.rand = new Random();
    }

    // action movement for Orca
    public Action getMove(CritterInfo info) {
        Action move;
        //move forward if empty
        if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;

        //see someone? Attack! 
        } else if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;

        //someone next door? Turn into the threat. 
        } else if (info.getRight() == Neighbor.OTHER) {
            move = Action.RIGHT;
        } else if (info.getLeft() == Neighbor.OTHER) {
            move = Action.LEFT;
        
        // if nothing else rings true, do this
        } else {
            move = Action.LEFT;
        }

        return move;
    }

    // return a color
    public Color getColor() {
        Color setColor;
        int randColorInt;

        // we can check if this.lastColorCode is initalized becase we are
        // adding 1 in the next step
        if (this.lastColorCode == 0) {

            // generate a new color
            randColorInt = this.rand.nextInt(0xffffff + 1);
        } else {

            // add 1 to the most recent color code
            randColorInt = this.lastColorCode + 1;
        }

        // format into hex code.
        String colorCode = String.format("#%06x", randColorInt);

        // set the color from a hex color code
        setColor = Color.decode(colorCode);

        // return the color code
        return setColor;
    }

    // define the UI element of the critter
    public String toString() {
        String name;

        // if the mod of 3 is even, display WCC,
        // else display ROCKS
        if (this.count % 3 == 0) {
            name = "WCC";
        } else {
            name = "ROCKS";
        }

        //move the count up
        this.count++;

        //return the name string
        return name;

    }

}
