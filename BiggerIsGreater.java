package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 * Based on https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 * Modified so that only one string printout is used.
 */
public class BiggerIsGreater {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();

        BiggerIsGreater big = new BiggerIsGreater();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            sb.append(big.nextPermutation(s.toCharArray()));
        }

        System.out.println(sb);

    }

    public String nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        String s = "";
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0){
            return "no answer\n";
            //return false;
        }

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(array);
        sb.append("\n");
        return sb.toString();
    }
}
