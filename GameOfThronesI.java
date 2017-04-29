package algorithm.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 11/02/2016.
 */
public class GameOfThronesI {

    public static boolean solve(HashMap<Character, Integer> hm, int length){
        // If length is even count of each element should be even
        if ((length & 1) == 0) {
            for (Integer i : hm.values()) {
                if ((i & 1) != 0){
                    return false;
                }
            }
        }

        // If the length is odd, count of each element besides 1 should be even.
        int numOdd = 0;
        if ((length & 1 ) != 0){
            for (Integer i : hm.values()) {
                if (numOdd > 1){
                    return false;
                }
                if ((i & 1) != 0){
                    numOdd++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        HashMap<Character, Integer> hm = new HashMap<>();

        String str = sc.next();
        char[] c = str.toCharArray();
        int length = c.length;

        for (int i = 0; i < length; i++) {
            if (hm.containsKey(c[i])) {
                int value = hm.get(c[i]);
                hm.put(c[i], value + 1);
            } else {
                hm.put(c[i], 1);
            }
        }

        if(solve(hm, length)){
            System.out.println("YES");
        }else
            System.out.println("NO");


    }
}
