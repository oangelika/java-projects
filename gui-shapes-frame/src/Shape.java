import java.awt.*;
import java.io.Serializable;

public class Shape implements Serializable {

    private int x, y, size, startX, startY, endX, endY;
    private Color color;
    private String type;


    public Shape(int x, int y, Color color, String type) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
        this.size = 50;
    }

    public Shape(int startX, int startY, int endX, int endY, Color color, String type) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}