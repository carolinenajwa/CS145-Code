// grab stuff we need
import java.awt.*;

public class Orca extends Critter {

    public Action getMove(CritterInfo info) {

        return Action.LEFT;
     }

     public Color getColor() {
        return Color.GRAY;
     }

     public String toString() {

        String status = "WCC";

        return status;
 
    }
}
