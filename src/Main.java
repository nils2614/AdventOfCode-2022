// Day 3 of Advent of Code by Nils Offermann
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);

            // Part 1
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                //code here
            }
            System.out.println("done");

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}