package algorithm.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jian on 3/02/2016.
 */
public class TheLongestCommonSubsequence {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner( new FileInputStream("testcase.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> result = new ArrayList<>();

        // opt[i][j] = length of LCS of s1[i..M] and y[j..N]
        int[][] opt = new int[m + 1][n + 1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //if (s1.charAt(i) == s2.charAt(j))
                if(b[i] == a[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (b[i] == a[j]) {
                //System.out.print(s1.charAt(i));
                //result++;
                result.add(a[j]);
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) i++;
            else j++;
        }

        for(Integer res : result) {
            System.out.print(res + " ");
        }
    }
}
