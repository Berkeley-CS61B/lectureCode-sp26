import org.jcodec.api.awt.AWTSequenceEncoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Rational;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

public class Mandelbrot {

    // --- Configuration ---
    private static final int WIDTH = 3840;       // 4K Width
    private static final int HEIGHT = 2160;      // 4K Height
    private static final int FPS = 60;
    private static final int DURATION_SEC = 15;
    private static final int MAX_ITER = 1000;    // Higher detail for deep zooms
    private static final String OUTPUT_FILE = "mandelbrot_4k.mp4";

    // --- Zoom Settings ---
    // An interesting coordinate in "Seahorse Valley"
    private static final double TARGET_X = -0.743643887037158;
    private static final double TARGET_Y = 0.131825904205311;
    
    // How fast we zoom in per frame (smaller = faster zoom)
    private static final double ZOOM_FACTOR = 0.97; 
    private static final double INITIAL_SCALE = 4.0 / WIDTH;

    public static void main(String[] args) {
        int totalFrames = DURATION_SEC * FPS;
        System.out.println("Initializing 4K Render: " + WIDTH + "x" + HEIGHT);
        System.out.println("Total Frames: " + totalFrames);

        File file = new File(OUTPUT_FILE);
        
        try {
            // Initialize the encoder
            AWTSequenceEncoder encoder = AWTSequenceEncoder.createSequenceEncoder(file, FPS);

            double currentScale = INITIAL_SCALE;

            for (int i = 0; i < totalFrames; i++) {
                long startTime = System.currentTimeMillis();

                // 1. Render the frame
                BufferedImage frame = renderFrame(currentScale);
                
                // 2. Encode the frame to MP4
                encoder.encodeImage(frame);

                // 3. Update zoom for next frame
                currentScale *= ZOOM_FACTOR;

                // Calculate progress/ETA
                long duration = System.currentTimeMillis() - startTime;
                System.out.printf("Frame %d/%d encoded. (Time: %dms) Scale: %e\n", 
                    (i + 1), totalFrames, duration, currentScale);
            }

            encoder.finish();
            System.out.println("Rendering complete. Video saved to: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error encoding video: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Renders a single frame of the Mandelbrot set using Parallel Streams.
     */
    private static BufferedImage renderFrame(double scale) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

        // Pre-calculate offsets to center the zoom target
        double xOffset = TARGET_X - (WIDTH / 2.0) * scale;
        double yOffset = TARGET_Y - (HEIGHT / 2.0) * scale;

        // Parallel stream processes rows concurrently for max speed
        IntStream.range(0, HEIGHT).parallel().forEach(y -> {
            for (int x = 0; x < WIDTH; x++) {
                // Map pixel to complex plane (cx, cy)
                double cx = x * scale + xOffset;
                double cy = y * scale + yOffset;

                int color = calculatePixelColor(cx, cy);
                image.setRGB(x, y, color);
            }
        });

        return image;
    }

    /**
     * Calculates the color for a specific point using smooth coloring.
     */
    private static int calculatePixelColor(double cx, double cy) {
        double zx = 0;
        double zy = 0;
        int iter = 0;

        // Cardioid check (optimization to skip main body calculation)
        double q = (cx - 0.25) * (cx - 0.25) + cy * cy;
        if (q * (q + (cx - 0.25)) < 0.25 * cy * cy) return 0x000000;

        while (zx * zx + zy * zy < 4 && iter < MAX_ITER) {
            double temp = zx * zx - zy * zy + cx;
            zy = 2 * zx * zy + cy;
            zx = temp;
            iter++;
        }

        if (iter == MAX_ITER) {
            return 0x000000; // Black for inside the set
        }

        // Smooth coloring algorithm to avoid "banding"
        // log_2(log(|z|)) / log(2)
        double log_zn = Math.log(zx * zx + zy * zy) / 2;
        double nu = Math.log(log_zn / Math.log(2)) / Math.log(2);
        double smoothIter = iter + 1 - nu;

        // Convert iteration count to an HSB color
        // Adjusting the 0.95f and 256.0f changes the color palette/cycling speed
        float hue = (float) (0.95f + 10 * smoothIter / MAX_ITER);
        return Color.HSBtoRGB(hue, 0.6f, 1.0f);
    }
}