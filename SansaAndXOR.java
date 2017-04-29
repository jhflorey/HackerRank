package algorithm.bitmanipulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 */
public class SansaAndXOR {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            solve(arr);
        }
    }

    public static void solve(int[] arr) {
        if ((arr.length & 1) == 0) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                sum ^= arr[i];
                //System.out.print(i + " ");
            }
        }
        System.out.println(sum);
    }
}
