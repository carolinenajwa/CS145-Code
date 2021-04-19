// This defines the Bear Class. Bears infect if an enemy is in front. 
// Otherwise hops or turns left. Bears flips between BLACK = Bear and WHITE = Polar Bear and 
// returns a character that alternate on each different move between a 
// slash character (/) and a backslash character(\).

import java.lang.reflect.Constructor;
import java.awt.*;

 
   
// Bear subclass of Critter
public class Bear extends Critter {

   // Private methods measuring count number of occurrences characters 
   // and color of Bear
   private int count;
   private boolean polar;
    
   // Bear class constructor
   public Bear(boolean polar) {
      this.count = 0;
      this.polar = polar;      
    }
    
    // Returns Bear movement
    public Action getMove(CritterInfo info) {
        Action move;
        if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;
      } else {
            move = Action.LEFT;
      }
        return move;
     }
  
 
   
    // Returns Polar Bear/Bear colors
    public Color getColor() {
       Color setcolor;
       if (this.polar) {
            setcolor = Color.WHITE;
     } else { 
            setcolor = Color.BLACK;
     }
       return setcolor;
    }

    // Returns charaters displaying Bear
    public String toString() {
       String character;
       this.count = this.count + 1;
       if (count % 2 == 1) {
            character = "/";
     } else {
            character = "\\";
     } 
       return character;
    }      
}
