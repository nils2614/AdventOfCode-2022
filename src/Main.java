// Day 2 of Advent of Code by Nils Offermann
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);
            int totalScore = 0;

            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                totalScore = totalScore + calcScore(line);
                //System.out.println(line.charAt(0) + "" + line.charAt(2) + ": " + calcScore(line));
            }
            System.out.println(totalScore);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static int calcScore(String line) {
        char c1 = line.charAt(0);
        char c2 = line.charAt(2);
        if (c1 == 'A') {
            switch(c2) {
                case 'X':
                    return 4;
                case 'Y':
                    return 8;
                case 'Z':
                    return 3;
                default:
                    return -1;
            }
        }
        else if (c1 == 'B') {
            switch(c2) {
                case 'X':
                    return 1;
                case 'Y':
                    return 5;
                case 'Z':
                    return 9;
                default:
                    return -1;
            }
        }
        else if (c1 == 'C') {
            switch(c2) {
                case 'X':
                    return 7;
                case 'Y':
                    return 2;
                case 'Z':
                    return 6;
                default:
                    return -1;
            }
        }
        else {
            return -1;
        }
    }
}