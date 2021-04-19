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
