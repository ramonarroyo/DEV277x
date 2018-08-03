import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private Random rand;
    private static Color[] COLORS = {Color.RED, Color.GREEN, Color.BLUE};
    private int count;
    private Color currentColor;

    public Tiger(){
        rand = new Random();
    }

    public Action getMove(CritterInfo info) {
        count++;
        count %= 3;
        Neighbor front = info.getFront();
        Neighbor right = info.getRight();
        if (front == Neighbor.OTHER) return Action.INFECT;
        else if (front == Neighbor.WALL || right == Neighbor.WALL) return Action.LEFT;
        else if (front == Neighbor.SAME) return Action.RIGHT;
        else return Action.HOP;
    }

    public Color getColor() {
        if (count == 0) currentColor = COLORS[rand.nextInt(COLORS.length)];
        return currentColor;
    }

    @Override
    public String toString() {
        return "TGR";
    }
}
