package algorithm.implementation;

import java.util.*;
import java.math.*;

public class ExtraLongFactorial {

    public static void main(String args[]) {
        int n, c;
        BigInteger inc = new BigInteger("1");
        BigInteger fact = new BigInteger("1");

        Scanner input = new Scanner(System.in);

        n = input.nextInt();

        for (c = 1; c <= n; c++) {
            fact = fact.multiply(inc);
            inc = inc.add(BigInteger.ONE);
        }

        System.out.println(n + "! = " + fact);
    }
}
