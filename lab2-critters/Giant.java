//Defines the Giant class. This class extends 
//the Critter class. The token for the 
//character changes between between 
//fee, fie, foe, fum every 6 moves
//The color returned is always GRAY

// grab stuff we need
import java.awt.*;

public class Giant extends Critter {
    // count helps us keep track of our iterations
    private int count;

    // Giant
    public Giant() {
        this.count = 0;
    }

    // action movement for Giant
    public Action getMove(CritterInfo info) {
        // create the move action
        Action move;

        // use logic for the next move
        if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;
        } else {
            move = Action.RIGHT;
        }

        // return that move
        return move;
    }

    // return gray color
    public Color getColor() {
        return Color.GRAY;
    }

    // define the UI element of the critter
    public String toString() {
        String status;

        // move between fee, fie, foe, fum every 6 moves
        if (this.count <= 5) {
            status = "fee";
        } else if (this.count > 5 && this.count <= 11) {
            status = "fie";
        } else if (this.count > 11 && this.count <= 17) {
            status = "foe";
        } else {
            status = "fum";
        }

        // move the count up
        this.count++;

        // reset the count
        if (this.count >= 23) {
            this.count = 0;
        }

        // return the name
        return status;

    }

}
