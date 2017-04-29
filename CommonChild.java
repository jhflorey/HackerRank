package algorithm.strings;

import java.util.*;

/**
 * Created by Jian on 31/01/2016.
 */
public class CommonChild {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int M = s1.length();
        int N = s2.length();
        int result = 0;

        // opt[i][j] = length of LCS of s1[i..M] and y[j..N]
        int[][] opt = new int[M + 1][N + 1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while (i < M && j < N) {
            if (s1.charAt(i) == s2.charAt(j)) {
                //System.out.print(s1.charAt(i));
                result++;
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1]) i++;
            else j++;
        }
        System.out.println(result);
    }
}

