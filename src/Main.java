import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        try {
            File myInput = new File("./src/input.txt");
            Scanner myScan = new Scanner(myInput);

            int elfen = 1;
            while (myScan.hasNextLine()) {
                String line = myScan.nextLine();
                if (line.isEmpty()) {
                    elfen++;
                }
            }
            //System.out.println(elfen);

            int[] calories = new int[elfen];
            myScan = new Scanner(myInput);
            String line;

            for (int i = 0; i < elfen; i++) {
                while (myScan.hasNextLine()) {
                    line = myScan.nextLine();
                    if (!line.isEmpty()) {
                        calories[i] += Integer.parseInt(line);
                        //System.out.println(i + ": " + line);
                    }
                    else {
                        break;
                    }
                }
            }

            Arrays.sort(calories);
            System.out.println("The elf with the most calories carries: " + calories[250] + " calories.");
            myScan.close();

        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}