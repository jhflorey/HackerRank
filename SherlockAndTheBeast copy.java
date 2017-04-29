package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class SherlockAndTheBeast {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int noOfTestCases = sc.nextInt();
        
        for(int i = 0 ; i < noOfTestCases; i++){
            System.out.println(getMaxDecentNumber(sc.nextInt()));
        }
    }
    
    

    public static String getMaxDecentNumber(int n) {

        int numberOfFives = -1;

        for (int f = 0; f <= n; f++) {
            int t = n - f;

            if (f % 3 == 0 && t % 5 == 0) {
                numberOfFives = f;
            }
        }

        if (numberOfFives == -1) {
            return "-1";
        } else {
            char fiveChar = '5';
            char threeChar = '3';

            char[] fiveChars = new char[numberOfFives];
            Arrays.fill(fiveChars, fiveChar);
            char[] threeChars = new char[n - numberOfFives];
            Arrays.fill(threeChars, threeChar);

            String fives = new String(fiveChars);
            String threes = new String(threeChars);
            String maxDecentNumber = fives + threes;

            return maxDecentNumber;
        }
    }
}
