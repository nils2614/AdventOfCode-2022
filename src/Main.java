// Day 3 of Advent of Code by Nils Offermann
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);
            int totalPriority = 0;

            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                totalPriority += priorityOfDublicate(line);
                //System.out.println(findDublicate(line)); // Test the findDublicate() method
            }
            System.out.println("The sum of the priorities of the dublicates is: " + totalPriority);
            //System.out.println(priorityOfDublicate("CrZsJsPPZsGzwwsLwLmpwMDw")); // Test with any given string

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
        int asciiValue = findDublicate(line);

        if ((asciiValue > 96) && (asciiValue < 123)) { // test for lowercase letter
            return asciiValue - 96;
        }
        else if ((asciiValue > 64) && (asciiValue < 91)) { // test for uppercase letter
            return asciiValue - 38;
        }
        else {
            return -1;
        }
    }
}