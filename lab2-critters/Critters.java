//LAB 2 - Critters 
//Gavin Stuart and Caroline El Jazmi
//4/20/21

//All 4 classes are present

// This defines the BEAR Class. BEARS infect if an enemy is in front. 
// Otherwise hops or turns left. BEARS flips between BLACK and WHITE and 
// returns a character that alternate on each different move between a 
// slash character (/) and a backslash character.

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
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;

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
        this.count = this.count + 1;
        if (count % 2 == 1) {
            return "/";
        } else {
            return "\\";
        }
    }
}


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

//The Orca Class. This displays as WCC/ROCKS alternately. 
//The color is generated randomly the first time, then the 
//previous critter's color is return and incremented slightly. 
//The color is not random after the first turn. 

// grab stuff we need
import java.awt.*;
import java.util.*;

public class Orca extends Critter {
    // count helps us keep track of our iterations
    private int count;
    // random number generator
    private Random rand;
    // keep track of the last color code
    private int lastColorCode;

    // Orca class with counter
    public Orca() {
        this.count = 0;
        this.rand = new Random();
    }

    // action movement for Orca
    public Action getMove(CritterInfo info) {
        Action move;
        //move forward if empty
        if (info.getFront() == Neighbor.EMPTY) {
            move = Action.HOP;

        //see someone? Attack! 
        } else if (info.getFront() == Neighbor.OTHER) {
            move = Action.INFECT;

        //someone next door? Turn into the threat. 
        } else if (info.getRight() == Neighbor.OTHER) {
            move = Action.RIGHT;
        } else if (info.getLeft() == Neighbor.OTHER) {
            move = Action.LEFT;
        
        // if nothing else rings true, do this
        } else {
            move = Action.LEFT;
        }

        return move;
    }

    // return a color
    public Color getColor() {
        Color setColor;
        int randColorInt;

        // we can check if this.lastColorCode is initalized becase we are
        // adding 1 in the next step
        if (this.lastColorCode == 0) {

            // generate a new color
            randColorInt = this.rand.nextInt(0xffffff + 1);
        } else {

            // add 1 to the most recent color code
            randColorInt = this.lastColorCode + 1;
        }

        // format into hex code.
        String colorCode = String.format("#%06x", randColorInt);

        // set the color from a hex color code
        setColor = Color.decode(colorCode);

        // return the color code
        return setColor;
    }

    // define the UI element of the critter
    public String toString() {
        String name;

        // if the mod of 3 is even, display WCC,
        // else display ROCKS
        if (this.count % 3 == 0) {
            name = "WCC";
        } else {
            name = "ROCKS";
        }

        //move the count up
        this.count++;

        //return the name string
        return name;

    }

}
