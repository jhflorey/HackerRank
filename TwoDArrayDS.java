package datastructures.arrays.Arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by Jian on 13/02/2016.
 */
public class TwoDArrayDS {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        ArrayList<Integer> str = new ArrayList<>();

        while (sc.hasNext()) {
            str.add(sc.nextInt());
        }

        // Set sum to the MIN VALUE of int.
        int sum = Integer.MIN_VALUE;
        int count = 0;


        // Imagine the 2d array as a continous string. We know all the positions and final position. These are not magic numbers.
        for (int i = 0; i < str.size() - 14; i++) {
            count++;
            if(count > (Math.sqrt(str.size()) / 2) + 1){
                count = 0;
                i++;
                continue;
            }
            int value = str.get(i) + str.get(i + 1) + str.get(i + 2) + str.get(i + 7) + str.get(i + 12) + str.get(i + 13) + str.get(i + 14);

            sum = Math.max(sum, value);
        }

        System.out.println(sum);

    }
}
