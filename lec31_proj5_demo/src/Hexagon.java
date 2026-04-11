package lec31_proj5_demo.src;

import lec31_proj5_demo.src.tileengine.TETile;
import lec31_proj5_demo.src.tileengine.Tileset;

import static lec31_proj5_demo.src.DrawUtils.drawHorizontalLine;

public class Hexagon {
    private int size;
    private TETile biome;
    private int topLeftX;
    private int topLeftY;

    public Hexagon(int size, TETile biome, int topLeftX, int topLeftY) {
        this.size = size;
        this.biome = biome;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    /* I'm destructively putting myself in the world. */
    public void addHexagon(TETile[][] world) {
        // could do bounds checking, but I'm craaazzayuy

        // top half first, draw size lines, each a bigger than the last
        // and each a bit over from the previous
        for (int lineNum = 0; lineNum < size; lineNum += 1) {
            drawHorizontalLine(topLeftX - lineNum, topLeftY - lineNum, size + lineNum * 2, biome, world);
        }

        int startBottomHalfX = topLeftX - size + 1;
        int startBottomHalfY = topLeftY - size;
        int startBottomHalfSize = size + size * 2 - 2;

        // bottom half of hexagon
        for (int lineNum = 0; lineNum < size; lineNum += 1) {
            drawHorizontalLine(startBottomHalfX + lineNum, startBottomHalfY - lineNum,
                    startBottomHalfSize - lineNum * 2, this.biome, world);
        }
        
    }

}