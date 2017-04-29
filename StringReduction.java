package algorithm.dynamic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 5/02/2016.
 */
public class StringReduction {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int a = 0; a < noOfTestCases; a++) {

            String s = sc.next();
            HashMap<Character, Integer> hm = new HashMap<>();

            hm.put('a',0);
            hm.put('b',0);
            hm.put('c',0);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer value = hm.get(new Character(c));
                if (hm.containsKey(c)) {
                    hm.put(c, hm.get(c) + 1);
                } else {
                    hm.put(c, 1);
                }
            }
            System.out.println(solve(hm, s));
        }
    }

    public static int solve(HashMap<Character, Integer> hm, String s){
        if (hm.get('a') % 2 == 0
                && hm.get('b') % 2 == 0
                && hm.get('c') % 2 == 0){
            return  2;
        }

        //If all even
        if (hm.get('a') % 2 != 0
                && hm.get('b') % 2 != 0
                && hm.get('c') % 2 != 0){
            return 2;
        }

        if (hm.get('a') == 0 && hm.get('b') == 0 && hm.get('c') != 0) {
            return s.length();
        }

        if (hm.get('b') == 0 && hm.get('c') == 0 && hm.get('a') != 0) {
            return s.length();
        }

        if (hm.get('a') == 0 && hm.get('b') != 0 && hm.get('c') == 0) {
            return s.length();
        }


        return 1;
    }
}
