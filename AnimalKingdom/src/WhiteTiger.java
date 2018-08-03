import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean infected;

    public WhiteTiger(){}

    public Action getMove(CritterInfo info) {
        Neighbor front = info.getFront();
        Neighbor right = info.getRight();
        if (front == Neighbor.OTHER){
            infected = true;
            return Action.INFECT;
        }
        else if (front == Neighbor.WALL || right == Neighbor.WALL) return Action.LEFT;
        else if (front == Neighbor.SAME) return Action.RIGHT;
        else return Action.HOP;
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public String toString() {
        if (infected) return "TGR";
        return "tgr";
    }
}
