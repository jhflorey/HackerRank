package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 1/02/2016.
 */
public class StockMaximize {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();


        for (int i = 0; i < noOfTestCases; i++) {
            int size = sc.nextInt();
            int[] predictedPrices = new int[size];

            for (int a = 0; a < size; a++) {
                predictedPrices[a] = sc.nextInt();
            }
            System.out.println(calcProfit(predictedPrices));

        }
    }

    public static long calcProfit(int[] a) {
        int[] buy = new int[a.length];
        long profit = 0;
        int m = 0;

        for (int i = 0; i < buy.length; i++) {
            buy[i] = 1;
        }

        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(i + " ");
            int value = a[i];
            if (m <= value) {
                buy[i] = 0;
                m = value;
            }
            profit = profit + m - value;
        }

        return profit;
    }
}
