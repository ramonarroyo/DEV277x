import java.awt.*;

public class Giant extends Critter {
    private int count;

    public Giant(){}

    public Action getMove(CritterInfo info) {
        count++;
        count %= 25;
        Neighbor front = info.getFront();
        if (front == Neighbor.OTHER) return Action.INFECT;
        else if (front == Neighbor.EMPTY) return Action.HOP;
        else return Action.RIGHT;
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        if (count <= 6) return "fee";
        else if (count <= 12) return "fie";
        else if (count <= 18) return "foe";
        else return "fum";
    }
}
