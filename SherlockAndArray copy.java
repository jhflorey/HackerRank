package algorithm.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 14/02/2016.
 */
public class SherlockAndArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("testcase.txt"));

        int noOfTestCases = scanner.nextInt();

        for (int j = 0; j < noOfTestCases; j++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }

            int right = 0;
            int left = sum;
            boolean flag = false;

            if (arr.length == 1) {
                flag = true;
            } else {
                for (int i = 1; i < arr.length - 1; i++) {
                    right += arr[i - 1];
                    left = sum - right - arr[i];
                    if (right == left) {
                        flag = true;
                        break;
                    }

                }
            }

            if (!flag)
                System.out.println("NO");
            else
                System.out.println("YES");
        }

    }
}
