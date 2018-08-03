import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private String display = "\\";

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Action getMove(CritterInfo info) {
        Neighbor front = info.getFront();
        if (front == Neighbor.OTHER) return Action.INFECT;
        else if (front == Neighbor.EMPTY) return Action.HOP;
        else return Action.LEFT;
    }

    public Color getColor() {
        if (polar) return Color.WHITE;
        else return Color.BLACK;
    }

    public String toString() {
        if (display.equals("/")){
            display = "\\";
        } else {
            display = "/";
        }
        return display;
    }
}
