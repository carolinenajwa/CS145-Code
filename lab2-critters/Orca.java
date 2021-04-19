
// grab stuff we need
import java.awt.*;

public class Orca extends Critter {
    // count helps us keep track of our iterations
    private int count;
    private String lastMove;

    // Orca class with counter
    public Orca() {
        this.count = 0;
    }

    // action movement for Giant
    public Action getMove(CritterInfo info) {
        Action move;

        if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;
        } else {
            if(this.count % 2 == 0){
                move = Action.RIGHT;
            }else{
                move = Action.LEFT;
            }
            
        }

        return move;
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
