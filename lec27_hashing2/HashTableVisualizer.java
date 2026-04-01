package lec27_hashing2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashTableVisualizer {
    List<ColoredNumber> cns = new ArrayList<>();
    boolean randomNumbers = false;

    double scale = 1.0;
    int N = 20; // 0, 1, 2, ... 19
    int M = 6;
    int pauseTime = 200;

    /*double scale = 0.4;
    int M = 3000;
    int N = 3 * M / 4; // 2,250 items
    int pauseTime = 0;*/

    public void runSimulation() {

        StdRandom.setSeed(5);
        HashTableDrawingUtility.setScale(scale);
        List<ColoredNumber> cns = new ArrayList<>();
        if (!randomNumbers) {
            for (int i = 0; i < N; i += 1) {
                addAndVisualize(i);
            }
        } else {
            for (int i = 0; i < N; i += 1) {
                addAndVisualize(StdRandom.uniform(N * 10));
            }
        }
    }

    public static void main(String[] args) {
        HashTableVisualizer htv = new HashTableVisualizer();
        htv.runSimulation();
    }

    private void addAndVisualize(int n) {
        ColoredNumber cn = new ColoredNumber(n);
        cns.add(cn);
        visualize(cns, M, scale);
        StdDraw.pause(pauseTime);
    }

    public void visualize(List<ColoredNumber> cns, int M, double scale) {
        HashTableDrawingUtility.drawLabels(M);

        int[] numInBucket = new int[M];
        for (ColoredNumber s : preprocess(cns)) {
            int bucketNumber = Math.floorMod(s.hashCode(), M);
            double x = HashTableDrawingUtility.xCoord(numInBucket[bucketNumber]);
            numInBucket[bucketNumber] += 1;
            double y = HashTableDrawingUtility.yCoord(bucketNumber, M);
            s.draw(x, y, scale);
        }
        StdDraw.show();
    }

    /** Simulate the deduplicating effect of a hash set */
    private static List<ColoredNumber> preprocess(List<ColoredNumber> oomages) {
        List<ColoredNumber> newList = new ArrayList<>();
        for (ColoredNumber element : oomages) {
            if (newList.contains(element)) {
                newList.remove(element);
            }
            newList.add(element);
        }
        return newList;
    }


} 
