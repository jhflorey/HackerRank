package projecteuler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 22/02/2016.
 */
public class ProjectEuler2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(sc.nextLong());
        }
    }

    public static long fib(long n) {
        long i = 1;
        long sum = 0;

        long f0 = 2;
        long f1 = 8;
        long f2 = 0;
        while (f1 <= n) {
            sum += f1;
            f2 = 4 * f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return sum + 2;
    }

}
