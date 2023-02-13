// Day 4 of Advent of Code by Nils Offermann
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);

            // Part 1
            int containedSets = 0;
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                if (isFullyContained(line)) {
                    containedSets++;
                }
            }
            System.out.println("Fully contained assignment pairs: " + containedSets);

            // Part 2
            int overlappingSets = 0;
            myScan = new Scanner(myInput);
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                if (isOverlapping(line)) {
                    overlappingSets++;
                }
            }
            System.out.println("Overlapping assignment pairs: " + overlappingSets);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static Boolean isFullyContained(String line) {
        int[] idList = getIDs(line);
        if (idList[0] <= idList[2] && idList[1] >= idList[3]) {
            return true;
        }
        else if (idList[2] <= idList[0] && idList[3] >= idList[1]) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Boolean isOverlapping(String line) {
        int[] idList = getIDs(line);
        // very ugly solution, but works ¯\_(ツ)_/¯
        if (idList[2] >= idList[0] && idList[2] <= idList[1]) { return true; }
        if (idList[3] >= idList[0] && idList[3] <= idList[1]) { return true; }
        if (idList[0] >= idList[2] && idList[0] <= idList[3]) { return true; }
        if (idList[1] >= idList[2] && idList[1] <= idList[3]) { return true; }
        return false;
    }

    public static int[] getIDs(String line) {
        int[] idList = {0, 0, 0, 0};
        int id = 0;
        for (int i = 0; i < line.length(); i++) {
            if (isNumber(i, line)) {
                idList[id] = idList[id] * 10 + line.charAt(i) - 48; // Append digit to int
            }
            else {
                id++;
            }
        }
        //System.out.println(idList[0] + " " + idList[1] + " " + idList[2] + " " + idList[3]); // debug print
        return idList;
    }

    public static Boolean isNumber(int pos, String string) {
        char myChar = string.charAt(pos);
        return (myChar > 47 && myChar < 58);
    }
}
