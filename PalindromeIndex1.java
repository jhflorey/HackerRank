package algorithm.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 3/02/2016.
 */
public class PalindromeIndex {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int no = sc.nextInt();

        for (int i = 0; i < no; i++) {
            System.out.println(solve(sc.next()));
        }
    }

    public static int solve(String s) {
        int length = s.length();
        char[] c = s.toCharArray();
        int lastIndex = length - 1;
        int half = lastIndex / 2;
        int result = -1;
        for (int i = 0, j = lastIndex; i <= half + 1 && j > half; i++, j--) {
            if (c[i] != c[j]) {
                if (c[i + 1] == c[j] && c[i + 2] == c[j - 1])
                    return i;
                if (c[i] == c[j - 1] && c[i + 1] == c[j - 2])
                    return j;
            }
        }
        return result;
    }
}
