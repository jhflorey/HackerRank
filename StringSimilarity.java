package algorithm.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Based on http://binfalse.de/2010/09/08/advanced-searching-via-z-algorithm/
 * The question requires the addition of the initial string length and calculation in bigint to pass last 2 cases
 */
public class StringSimilarity {

    private int[] z;
    private char[] text;

    public StringSimilarity() {
        z = null;
        text = null;
    }

    public int findPrefixLength(char[] text, int a, int b) {
        int len = 0;
        for (int i = 0; i + a < text.length && i + b < text.length; i++) {
            if (text[i + a] == text[i + b]) len++;
            else break;
        }
        return len;
    }

    public void calcZbox(String word) {
        text = word.toCharArray();
        z = new int[text.length];
        int l = 0;
        int r = 0;


        if (z.length > 1) z[1] = findPrefixLength(text, 0, 1);
        else return;

        if (z[1] > 0) {
            l = 1;
            r = z[1];
        }

        for (int j = 2; j < text.length; j++) {
            if (j > r) //case 1
            {
                z[j] = findPrefixLength(text, 0, j);
                if (z[j] > 0) {
                    l = j;
                    r = j + z[j] - 1;
                }
            } else //case 2
            {
                int k = j - l;
                if (z[k] < r - j + 1) //case 2a
                {
                    z[j] = z[k];
                } else //case 2b
                {
                    int p = findPrefixLength(text, r - j + 1, r + 1);
                    z[j] = r - j + 1 + p;
                    l = j;
                    r = j + z[j] - 1;
                }
            }
        }
    }

    public String toString() {
        String s = "ZBoxes:\n";
        for (int i = 0; i < text.length; i++)
            s += text[i] + "\t";
        s += "\n\t";
        for (int i = 1; i < z.length; i++)
            s += z[i] + "\t";
        return s + "\n";
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            StringSimilarity z = new StringSimilarity();
            z.calcZbox(sc.next());

            System.out.println(z.stringSimilarity());
        }

    }

    public BigInteger stringSimilarity() {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i < z.length; i++) {
            BigInteger bi = new BigInteger(z[i] + "");
            sum = sum.add(bi);
        }

        BigInteger bigInteger = new BigInteger(text.length + "");
        sum = sum.add(bigInteger);

        return sum;
    }
}