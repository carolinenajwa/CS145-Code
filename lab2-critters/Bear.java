import java.lang.reflect.Constructor;

// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.


import java.awt.*;

 
   
// Bear subclass of Critter
public class Bear extends Critter {

    // Private methods measuring count number of occurrences characters 
    // and color of Bear
    private int count;
    private boolean polar;
    
    // Bear class constructor
    public Bear(boolean polar) {
         this.count = 0
         this.polar = polar;
         
    }
    
    // Returns Bear movement
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
      } if (info.getDirection() == Neighbor.EMPTY){
            return Action.HOP;
        }
     }
   
    // Returns Polar Bear/Bear colors
    public Color getColor() {
        if (this.polar) {
            return Color.WHITE;
       } else { 
            return Color.BLACK;
            }
          }

    // Returns charaters displaying Bear
    public String toString() {
        this.count = this.count + 1
        if (count % 2 == 1) {
            return "/";
        } else {
            return "\\"
     } 
     }      
    }
