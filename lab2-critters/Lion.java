// This defines the Lion Class. Lions infect if an enemy is in front. 
// Otherwise if a wall is in front or to the right, then turn left. Otherwise if a fellow Lion is in front, then turn right. Otherwise hop.
// Lions randomly picks one of three colors (red, green, blue), then randomly picks one of those colors again for the next three moves, and so on.
// Lions return the character "L". 

import java.awt.*;
import java.util.*;

// Lion subclass of Critter
public class Lion extends Critter {

     // Private methods measuring count number of occurrences characters
     // and random color of Lion
     private Random rand;
     private int counter;
     private int x;

     // Lion class constructor
     public Lion() {
          rand = new Random();
          counter = 0;
          x = rand.nextInt(3);
     }

     // Returns Lion movement
     public Action getMove(CritterInfo info) {
          counter++;
          Action move;
          if (info.getFront() == Neighbor.OTHER) {
               move = Action.INFECT;
          } else if ((info.getFront() == Neighbor.WALL) || (info.getRight() == Neighbor.WALL)) {
               move = Action.LEFT;
          } else if (info.getFront() == Neighbor.SAME) {
               move = Action.RIGHT;
          } else {
               move = Action.HOP;
          }
          return move;
     }

     // Returns random Lion color every three moves
     public Color getColor() {
          Color setcolor;
          if (counter % 3 == 0) {
               x = rand.nextInt(3);
          }
          if (x == 0) {
               setcolor = Color.RED;
          } else if (x == 1) {
               setcolor = Color.GREEN;
          } else {
               setcolor = Color.BLUE;
          }
          return setcolor;
     }

     // Returns character displaying Lion
     public String toString() {
          return "L";
     }
}
