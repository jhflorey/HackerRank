package weekofcode19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 22/02/2016.
 */
public class TwoRobot {
    int[] a = new int[1005];
    int[] b = new int[1005];
    int[][] dp = new int[1005][1005];

    public void solve() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int t = sc.nextInt();
        for (int test = 0; test < t; ++test) {
            int nax = 1005;
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 1; i <= m; ++i) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }

            dp = new int[nax][nax];

            for (int i = 0; i < nax; ++i)
                for (int j = 1; j < nax; ++j)
                    dp[i][j] = 1000000000;

            int res = 1000000000;

            for (int i = 0; i < m; ++i) {
                for (int j = i; j <= m; ++j) {
                    if (j == m) {
                        res = Math.min(res, dp[i][j]);
                        continue;
                    }
                    int me = dp[i][j];
                    dp[i][j + 1] = Math.min(dp[i][j + 1], me + dist(j, j + 1));
                    dp[j][j + 1] = Math.min(dp[j][j + 1], me + dist(i, j + 1));
                }
            }
            System.out.println(res);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        TwoRobot tr = new TwoRobot();
        tr.solve();
    }

    public int dist(int i, int j) {
        if (i == 0)
            return Math.abs(b[j] - a[j]);;
        return Math.abs(a[j] - b[i]) + Math.abs(b[j] - a[j]);
    }

}
