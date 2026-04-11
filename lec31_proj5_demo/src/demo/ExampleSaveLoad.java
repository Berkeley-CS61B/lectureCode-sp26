package lec31_proj5_demo.src.demo;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.io.File;

public class ExampleSaveLoad {
    public static void main(String[] args) {
        String filename = "name.txt";
        File file = new File(filename);

        // Step 1: Check if the file exists and read the saved name
        if (file.exists()) {
            In in = new In(file);
            if (in.hasNextLine()) {
                String savedName = in.readLine();
                System.out.println("Hello, the last time you ran this program, your name was " + savedName);
            } else {
                System.out.println("I don't know your name.");
            }
        } else {
            System.out.println("I don't know your name.");
        }

        // Step 2: Prompt the user for their name
        System.out.print("Please enter your name: ");
        In keyboard = new In();  // Reads from standard input
        String currentName = keyboard.readLine();

        // Step 3: Save the new name to the file
        Out out = new Out(filename);
        out.println(currentName);
        out.close();
    }
}