package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 */
public class RunningTimeOfAlgorithms {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        insertionSort(arr);
    }

    public static void insertionSort(int[] ar) {
        int count = 0;
        for (int i = 1; i < ar.length; i++) {
            int temp = ar[i], j = i;
            for (; j > 0 && ar[j - 1] > temp; j--) {
                ar[j] = ar[j - 1];
                count++;
            }
            ar[j] = temp;

        }

        System.out.println(count);
    }

}
