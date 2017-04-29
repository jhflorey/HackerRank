package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 11/02/2016.
 */
public class ClosestNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);

        long min = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            long value = nums[i] - nums[i - 1];
            if (min > value) {
                min = value;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            long value = nums[i] - nums[i - 1];
            if (value == min) {
                System.out.print(nums[i - 1] + " " + nums[i] + " ");
            }
        }
    }
}
