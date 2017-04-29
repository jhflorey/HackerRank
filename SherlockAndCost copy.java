package algorithm.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 */
public class SherlockAndCost {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();

            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;

            //System.out.println(max);
            int low = 0;
            int high  = 0;

            for(int i = 0 ; i < b.length; i++){
                if (i > 0) {
                    int l = Math.max(Math.abs(1 - b[i - 1]) + high, low);
                    int h = Math.max(Math.abs(b[i] - 1) + low, Math.abs(b[i] - b[i - 1]) + high);
                    low = l;
                    high = h;
                }
            }

            System.out.println(Math.max(low,high));

        }
    }

    public void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int cost(int[] arr, int i) {

        return 0;
    }
}
