// Day 3 of Advent of Code by Nils Offermann
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);

            // Part 1
            int totalPriority = 0;
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                totalPriority += priorityOfDublicate(line);
                //System.out.println(findDublicate(line)); // Test the findDublicate() method
            }
            System.out.println("The sum of the priorities of the dublicates is: " + totalPriority);
            //System.out.println(priorityOfDublicate("CrZsJsPPZsGzwwsLwLmpwMDw")); // Test with any given string

            // Part 2
            myScan = new Scanner(myInput);
            totalPriority = 0;
            while (myScan.hasNextLine()) {
                String line1 = myScan.nextLine();
                String line2 = myScan.nextLine();
                String line3 = myScan.nextLine();
                totalPriority += priorityOfChar(findBadge(line1, line2, line3));
            }
            System.out.println("The sum of the priorities of the badges is: " + totalPriority);

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static char findDublicate(String line) {
        int compartmentSize = line.length() / 2;
        char dublicate;

        for (int i = 0; i < compartmentSize; i++) {
            dublicate = line.charAt(i);
            for (int j = compartmentSize; j < compartmentSize*2; j++) {
                if (dublicate == line.charAt(j)) {
                    return dublicate;
                }
            }
        }
        return ' ';
    }

    public static int priorityOfDublicate(String line) {
        return priorityOfChar(findDublicate(line));
    }

    public static int priorityOfChar(char x) {
        if ((x > 96) && (x < 123)) { // test for lowercase letter
            return x - 96;
        }
        else if ((x > 64) && (x < 91)) { // test for uppercase letter
            return x - 38;
        }
        else {
            return -1;
        }
    }

    public static char findBadge(String s1, String s2, String s3) {

        HashSet<Character> lineComp = new HashSet<Character>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lineComp.add(s1.charAt(i));
                }
            }
        }
        // System.out.println(lineComp);

        for (int i = 0; i < s3.length(); i++) {
            if (lineComp.contains(s3.charAt(i))) {
                return s3.charAt(i);
            }
        }
        return ' ';
    }
}