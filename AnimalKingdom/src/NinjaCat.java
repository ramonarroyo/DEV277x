import java.awt.*;
import java.util.Random;

public class NinjaCat extends Critter {
    private Random rand;
    private static Color[] COLORS = {Color.CYAN, Color.PINK};
    private int count;
    private Color currentColor;

    public NinjaCat(){
        rand = new Random();
    }

    public Action getMove(CritterInfo info) {
        count++;
        count %= 2;
        Neighbor front = info.getFront();
        Neighbor left = info.getLeft();
        Neighbor right = info.getRight();
        if (front == Neighbor.OTHER) return Action.INFECT;
        else if (left == Neighbor.OTHER) return Action.LEFT;
        else if (right == Neighbor.OTHER) return  Action.RIGHT;
        else if (front == Neighbor.WALL) return Action.LEFT;
        else if (front == Neighbor.SAME) return Action.RIGHT;
        else return Action.HOP;
    }

    public Color getColor() {
        if (count == 0) currentColor = COLORS[rand.nextInt(COLORS.length)];
        return currentColor;
    }

    @Override
    public String toString() {
        return "=^.^=";
    }
}
