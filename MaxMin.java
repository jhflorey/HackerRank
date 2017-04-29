package algorithm.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 4/02/2016.
 */
public class MaxMin {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.parallelSort(nums);
        int fairness = Integer.MAX_VALUE;

        //Generate subgroups
        for (int i = 0; i < n - k + 1; i++) {
            int min = nums[i];
            int max = nums[i + k - 1];
            if ((max - min) < fairness)
                fairness = max - min;
//            ArrayList<Integer> subGroup = new ArrayList<>();
//            for (int j = 0; j < k; j++) {
//                if (i + j > n - 1)
//                    break;
//                subGroup.add(nums[i + j]);
//            }
//            i++;
//            if(subGroup.size() == k) {
//                int diff = (subGroup.get(subGroup.size() - 1) - subGroup.get(0));
//                fairness = Math.min(fairness, diff);
//            }
        }

        System.out.println(fairness);
    }
}
