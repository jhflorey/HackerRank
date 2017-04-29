package algorithm.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Jian on 3/02/2016.
 */
public class TheLoveLetterMystery {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int noOfTestCases = sc.nextInt();

        for(int i = 0 ; i < noOfTestCases; i++){
            String str = sc.next();
            char[] c = str.toCharArray();
            solve(c,c.length);
        }

    }

    public static void solve(char[] c, int length){
        int result = 0;
        for(int i = 0, j = length - 1; i < length/2 && j >= length/2; i++, j-- ){
            if(c[i] != c[j]){
                result += Math.abs(c[i] - c[j]);
            }
        }
        System.out.println(result);
    }
}
