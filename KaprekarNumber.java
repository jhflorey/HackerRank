package algorithm.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 11/02/2016.
 */
public class KaprekarNumber {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int p = sc.nextInt();
        int q = sc.nextInt();

        boolean flag = solve(p, q);
        if (!flag) {
            System.out.print("INVALID RANGE");
        }

    }

    public static boolean solve(long p, long q) {
        boolean flag = false;
        for (long i = p; i <= q; i++) {
            long c = i * i;
            long sq = c;
            long count = 1;
            while (c / 10 != 0) {
                c = c / 10;
                count++;
            }
            if (count / 2 != 0) {
                count = count + 1;
            }
            long tens = (long) Math.pow(10, count / 2);
            long x = sq / tens;
            long y = sq % tens;
            if (x + y == i) {
                System.out.print(i + " ");
                flag = true;
            }
        }
        return flag;
    }
}
