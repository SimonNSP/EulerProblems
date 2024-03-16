package beans;

import java.util.Arrays;

public class Triangle {
    private final int[] sides;
    private final int scope;

    public Triangle(int[] sides, int scope) {
        this.sides = new int[4];
        this.sides[0] = sides[0];
        this.sides[1] = sides[1];
        this.sides[2] = sides[2];
        this.sides[3] = sides[3];
        this.scope = scope;

       // Arrays.sort(sides);
    }

    public boolean isRightTriangle() {
        return (Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2));
    }

    public boolean hasCorrectScope() {
        return (sides[0] + sides[1] + sides[2] == scope);
    }

    public int[] getSides() {
        return sides;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return String.valueOf(getSides()[0]) + String.valueOf(getSides()[1]) + String.valueOf(getSides()[2]);
    }
}
