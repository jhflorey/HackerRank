package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 */
public class ACMICPCTeam {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        String a[] = new String[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.next();

        int max = 0;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = 0;
                for (int k = 0; k < m; k++) {
                    if (a[i].charAt(k) == '1' || a[j].charAt(k) == '1')
                        sum++;
                }

                if (sum > max) {

                    count = 1;
                    max = sum;

                } else if (max == sum)
                    count++;
            }
        }
        System.out.print(max + "\n" + count);
    }
}
