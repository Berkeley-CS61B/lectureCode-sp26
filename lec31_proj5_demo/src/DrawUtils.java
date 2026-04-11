package lec31_proj5_demo.src;

import lec31_proj5_demo.src.tileengine.TETile;

public class DrawUtils {
    public static void drawHorizontalLine(int x, int y, int lineWidth, TETile biome, TETile[][] world) {
        for (int xOffset = 0; xOffset < lineWidth; xOffset += 1) {
            world[x + xOffset][y] = biome;
        }
    }
}
