package main.BasicClasses;

public class Coordinates {
    private float x;
    private long y;

    public Coordinates(float x, long y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return Float.toString(x) + " " + Long.toString(y);
    }
}