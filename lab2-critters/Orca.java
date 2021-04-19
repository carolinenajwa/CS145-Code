
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
            this.lastMove = "IF";
        } else if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;
            this.lastMove = "H";
        }else {
            if(this.count % 2 == 0){
                move = Action.RIGHT;
            }else{
                move = Action.LEFT;
            }
            
            this.lastMove = "L";
        }

        return move;
    }

    // return gray color
    public Color getColor() {
        Color setColor;

        if(this.count % 2 == 0){
            setColor = Color.RED;
        }else{
            setColor =  Color.BLACK;
        }

        this.count++;

        return setColor;
    }   

    // define the UI element of the critter
    public String toString() {

        return "WCC";

    }

}
