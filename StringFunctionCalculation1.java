package algorithm.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Jian on 2/02/2016.
 */
public class StringFunctionCalculation {

    public static int SIZE = 100050;
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        String s = sc.next();
        int length = s.length();
        int[] sa = suffixArray(s);
        int[] lcp = lcp(sa, s);

        System.out.println(solve(sa, lcp, length));
    }

    public static int solve(int[] sa, int[] lcp, int n) {

        int top = 0;
        lcp[n] = 0;
        int best = n;
        int[] lr = new int[SIZE];

        lr[top++] = 0;

        for (int i = 1; i < n + 1; i++) {
            while (top != 0 && lcp[i] < lcp[lr[top - 1]]) {
                int val = lcp[lr[top - 1]];
                top--;
                best = Math.max(best, val * (top == 0 ? i : i - lr[top - 1]));
            }
            if (top == 0 || lcp[i] >= lcp[lr[top - 1]])
                lr[top++] = i;
        }
        return best;
    }


    public static int[] lcp(int[] sa, CharSequence s) {
        int n = sa.length;
        int[] rank = new int[SIZE];
        for (int i = 0; i < n; i++)
            rank[sa[i]] = i;
        int[] lcp = new int[SIZE];
        lcp[0] = 0;
        for (int i = 0, h = 0; i < n; i++)
        {
            if (rank[i] < n - 1)
            {
                for (int j = sa[rank[i] + 1];
                     Math.max(i, j) + h < s.length()
                             && s.charAt(i + h) == s.charAt(j + h); ++h)
                    ;
                lcp[rank[i]] = h;
                if (h > 0)
                    --h;
            }
        }
        return lcp;
    }

    public static int[] suffixArray(CharSequence S) {
        int n = S.length();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = n - 1 - i;

        Arrays.parallelSort(order, (a, b) -> Character.compare(S.charAt(a), S.charAt(b)));

        int[] sa = new int[SIZE];
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = order[i];
            classes[i] = S.charAt(i);
        }

        for (int len = 1; len < n; len *= 2) {
            int[] c = classes.clone();
            for (int i = 0; i < n; i++) {

                classes[sa[i]] = i > 0 && c[sa[i - 1]] == c[sa[i]] && sa[i - 1] + len < n && c[sa[i - 1] + len / 2] == c[sa[i] + len / 2] ? classes[sa[i - 1]] : i;
            }
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++)
                cnt[i] = i;
            int[] s = sa.clone();
            for (int i = 0; i < n; i++) {
                int s1 = s[i] - len;
                if (s1 >= 0)
                    sa[cnt[classes[s1]]++] = s1;
            }
        }
        return sa;
    }
}
