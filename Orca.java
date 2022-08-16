//Walter Hathaway
//CS 145
//7/19/22
//This program will create the orca critter

import java.awt.*;
public class Orca extends Critter {
    public Orca() {
    }
   //String of the Orca
    public String toString() {
        return "><>";
    }
    //Color of the Orca
    public Color getColor() {
        return Color.BLUE;
    }
    //Actions of the orca
    public Action getMove(CritterInfo info) {
        double number = Math.random();
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getFront() ==
                Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.LEFT;
        }
    }
}
