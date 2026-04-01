package lec27_hashing2;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class HashTableDrawingUtility {
    private static final double X_OFFSET = 0.1;
    private static final double Y_OFFSET = 0.8;
    private static final double Y_SLACK_SPACE = 0.08;
    private static final int MAX_FONT_SIZE = 24;
    private static final double FONT_SCALING_FACTOR = 400.0;
    private static double scalingFactor = 1.0;

    public static void setScale(double sf) {
        scalingFactor = sf;
        StdDraw.setCanvasSize(800, 800);
        StdDraw.enableDoubleBuffering();
    }

    public static double xCoord(int bucketPos) {
        return bucketPos * 0.1 * scalingFactor + 1.5 * X_OFFSET * scalingFactor;
    }

    public static double yCoord(int bucketNum, int M) {
        double lineHeight = (1 - Y_SLACK_SPACE) / M;
        return (-bucketNum * lineHeight + Y_SLACK_SPACE * scalingFactor + Y_OFFSET  );
    }

    public static void drawLabels(int M) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.clear();

        int fontSize = (int) (Math.min(FONT_SCALING_FACTOR / M, MAX_FONT_SIZE) * scalingFactor);
        Font font = new Font("Consolas", Font.PLAIN, fontSize);
        StdDraw.setFont(font);

        for (int i = 0; i < M; i += 1) {
            double yCoord = yCoord(i, M);
            StdDraw.text(X_OFFSET * scalingFactor, yCoord, i + ": ");
        }
    }
} 
