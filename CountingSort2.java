package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 */
public class CountingSort2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] count = new int[100];

        Arrays.fill(count, 0);

        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
            count[arr[j]]++;
        }


        for(int i = 0; i < count.length; i++){
            for(int j = 0; j < count[i]; j++){
                System.out.print(i + " ");
            }
        }

    }
}
