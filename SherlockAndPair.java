package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 16/02/2016.
 */
public class SherlockAndPair {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int noOfTestCases = sc.nextInt();
        for (int a = 0; a < noOfTestCases; a++) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                if (!hm.containsKey(key)) {
                    hm.put(key, 1);
                } else {
                    int value = hm.get(key);
                    hm.put(key, value + 1);
                }
            }

            BigInteger sum = new BigInteger("0");
            for (Integer i : hm.values()) {
                if (i > 1) {
                    //sum = sum + i;
                    //sum += ( i * ( i - 1));
                    BigInteger bi = new BigInteger("1");
                    BigInteger bigIntI = BigInteger.valueOf(i.intValue());
                    BigInteger right = bigIntI.subtract(bi);
                    sum = sum.add(bigIntI.multiply(right));

                }
            }
            System.out.println(sum);
        }
    }
}
