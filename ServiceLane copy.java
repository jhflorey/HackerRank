package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Jian on 4/02/2016.
 */
public class ServiceLane {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int lengthOfFreeway = sc.nextInt();
        int noOfTestCases = sc.nextInt();
        int[] width = new int[lengthOfFreeway];

        for (int b = 0; b < lengthOfFreeway; b++) {
            width[b] = sc.nextInt();
        }

        //Pre-process data set

        for (int a = 0; a < noOfTestCases; a++) {
            int enter = sc.nextInt();
            int exit = sc.nextInt();
            int result = solve(width, enter, exit);
            System.out.println(result);
        }
    }

    // Simple way of evaluating the width. The complexity is potentially lower than O(n)
    // due to the return. However if no 1s are found it will still go to the end.
    public static int solve(int[] width, int enter, int exit) {
        boolean flag = false;
        for (int i = enter; i <= exit; i++) {
            if (width[i] == 1)
                return 1;
            if( width[i] == 2)
                flag = true;
        }
        if(flag)
            return 2;
        return 3;
    }

}

