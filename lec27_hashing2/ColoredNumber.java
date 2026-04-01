package lec27_hashing2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.List;

public class ColoredNumber {
    private static final List<Color> colors =
            List.of(Color.WHITE, Color.ORANGE, Color.CYAN, Color.GREEN, Color.YELLOW);

    public int num;
    public Color color;

    public ColoredNumber(int n) {
        num = n;
        color = getRandomColor();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ColoredNumber c) {
            return c.num == num;
        }
        return false;
    }

    public void draw(double x, double y, double scalingFactor) {
        StdDraw.setPenColor(new Color(0, 0, 0));
        StdDraw.filledSquare(x + scalingFactor * 0.01, y + scalingFactor * 0.005, 0.035 * scalingFactor);
        StdDraw.setPenColor(color);
        StdDraw.setFont(new Font("Consolas", Font.PLAIN, (int) (scalingFactor * 32)));
        StdDraw.text(x, y, String.format("%3d", num));
    }

    private static Color getRandomColor() {
        return colors.get(StdRandom.uniform(colors.size()));
    }

    public static void main() {
        IO.println(new ColoredNumber(3).hashCode());
        IO.println(new ColoredNumber(3).hashCode());
        IO.println(new ColoredNumber(6).hashCode());
    }
}










    /*@Override
    public int hashCode() {
        return num;
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (o instanceof ColoredNumber uddaCn) {
            return this.color.equals(uddaCn.color);
        }
        return false;
    }*/

