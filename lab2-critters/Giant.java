
// grab stuff we need
import java.awt.*;

public class Giant extends Critter {
    //count helps us keep track of our iterations 
    private int count;

    // Giant
    public Giant() {
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
        return Color.GRAY;
    }

    // define the UI element of the critter
    public String toString() {
        String status;


        // move between fee, fie, foe, fum every 6 moves
        if (this.count <= 6) {
            status = "fee";
        } else if (this.count > 6 && this.count <= 12) {
            status = "fie";
        } else if (this.count > 12 && this.count <= 18) {
            status = "foe";
        } else {
            status = "fum";
        }

        this.count++;

        if (this.count >= 24) {
            this.count = 0;
        }

        return status;

    }

}
