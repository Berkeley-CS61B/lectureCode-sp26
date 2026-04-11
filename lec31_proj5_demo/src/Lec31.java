package lec31_proj5_demo.src;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import lec31_proj5_demo.src.tileengine.TERenderer;
import lec31_proj5_demo.src.tileengine.TETile;
import lec31_proj5_demo.src.tileengine.Tileset;

/**
 * Draws a hexagon world (or at least that's the goal).
 */
public class Lec31 {
    private static int WIDTH = 45;
    private static int HEIGHT = 45;
    private static int HEX_SIZE = 4;

    private static void drawColumnOfHexagons(int x, int y, int numHexagons, TETile[][] world) {
        // to be filled in
        // this function should pick a random biome!
        for (int i = 0; i < numHexagons; i += 1) {
            Hexagon h = new Hexagon(HEX_SIZE, pickRandomBiome(), x, y - HEX_SIZE*2*i);
            h.addHexagon(world);
        }
    }

    private static TETile pickRandomBiome() {
        int choice = StdRandom.uniformInt(5);
        switch (choice) {
            case 0: return Tileset.SAND;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.TREE;
            case 4: return Tileset.GRASS;
            default: return Tileset.LOCKED_DOOR;
        }
    }

    static void main() {

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT); // creates a 45 x 45 window

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        int firstX = 6;
        int firstY = 36;
        drawColumnOfHexagons(firstX, firstY, 3, world);
        drawColumnOfHexagons(firstX + 2*HEX_SIZE - 1, firstY + HEX_SIZE, 4, world);
        drawColumnOfHexagons(firstX + 4*HEX_SIZE - 2, firstY + 2*HEX_SIZE, 5, world);
        drawColumnOfHexagons(firstX + 6*HEX_SIZE - 3, firstY + HEX_SIZE, 4, world);
        drawColumnOfHexagons(firstX + 8*HEX_SIZE - 4, firstY, 3, world);
        
        int avatarX = 5;
        int avatarY = 9;

        TETile whatUsedToBeInMyNewSpot = world[avatarX][avatarY];
        world[avatarX][avatarY] = Tileset.AVATAR;

        StdDraw.clear(); // makes the world pure white
        ter.drawTiles(world); // draws all the tile
        StdDraw.show();

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char c = StdDraw.nextKeyTyped();
                
                if (c == 's') {
                    avatarY -= 1;
                    world[avatarX][avatarY + 1] = whatUsedToBeInMyNewSpot;
                } else if (c == 'a') {
                    avatarX -= 1;
                    world[avatarX + 1][avatarY] = whatUsedToBeInMyNewSpot;
                } else if (c == 'd') {
                    avatarX += 1;
                    world[avatarX - 1][avatarY] = whatUsedToBeInMyNewSpot;
                } else if (c == 'w') {
                    avatarY += 1;
                    world[avatarX][avatarY - 1] = whatUsedToBeInMyNewSpot;
                }

                whatUsedToBeInMyNewSpot = world[avatarX][avatarY];
                world[avatarX][avatarY] = Tileset.AVATAR;

                StdDraw.clear(); // makes the world pure white
                ter.drawTiles(world); // draws all the tile
                StdDraw.show();
            }            
        }
    }
}