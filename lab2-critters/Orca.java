
// grab stuff we need
import java.awt.*;

public class Orca extends Critter {
    //count helps us keep track of our iterations 
    private int count;

    // Orca class with counter
    public Orca() {
        this.count = 0;
    }

    // action movement for Giant
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    // return gray color
    public Color getColor() {
        return Color.RED;
    }

    // define the UI element of the critter
    public String toString() {

        return "WCC";

    }

}
