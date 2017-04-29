package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 */
public class TaumAndBday {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int noOfTestCases = sc.nextInt();

        for(int i = 0; i < noOfTestCases; i++) {

            long black = sc.nextLong();
            long white = sc.nextLong();

            long costX = sc.nextLong();
            long costY = sc.nextLong();
            long convertCost = sc.nextLong();

            long totalCost = 0;

            //No benefit if all the same value
            if ((costX == costY) && (convertCost == costY))
                totalCost = black * costX + white * costY;
            //If the convert cost is higher buy manually
            if ((convertCost > costX) && (convertCost > costY))
                totalCost = black * costX + white * costY;

            //System.out.println(totalCost);

            // x = (x <= (y + z)) ? x : (y + z);
            // y = (y <= (x + z)) ? y : (x + z);
            totalCost = black  *  Math.min(costX, costY+convertCost) + white *  Math.min(costY, costX+convertCost);
            System.out.println(totalCost);
        }


    }
}
