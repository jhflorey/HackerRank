package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 16/02/2016.
 *
 * This is not the right way of doing it because the in-built sort function is used.
 */
public class FindTheMedian {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[n/2]);

    }
}
