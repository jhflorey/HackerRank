package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Previous solution was recursive. This solution uses an array which stores the values of the previous
 * numbers. This performs faster based on basic testing.
 */
public class FibonacciModified {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        BigInteger[] ans = new BigInteger[n];
        ans[0] = BigInteger.valueOf(a);
        ans[1] = BigInteger.valueOf(b);

        for(int i = 2; i < n; i++){
            ans[i] = ans[i-1].multiply(ans[i-1]).add(ans[i-2]);
        }

        System.out.println(ans[n-1]);
    }
}
