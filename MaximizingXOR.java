package algorithm.bitmanipulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaximizingXOR {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(maxXor(l, r));

    }

    static int maxXor(int l, int r) {
        int xor = l ^ r;
        int i = 0;

        while (Math.pow(2, i) < xor) {
            i++;
        }

        return (int) Math.pow(2, i) - 1;
    }
}
