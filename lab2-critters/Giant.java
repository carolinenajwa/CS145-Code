// grab stuff we need
import java.awt.*;

public class Giant extends Critter{
    public Action getMove(CritterInfo info) {
        return Action.INFECT;
     }

     public Color getColor() {
        return Color.GRAY;
     }

     public String toString() {
        return "fee";
 
    }
}
