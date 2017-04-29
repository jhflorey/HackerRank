package algorithm.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 */
public class TwoStrings {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for(int a = 0; a < noOfTestCases; a++) {
            final Map<String, Integer> m = new HashMap<String, Integer>();

            String s1 = sc.next();
            String s2 = sc.next();

            for (int b = 0; b < s1.length(); b++) {
                m.put(s1.charAt(b) + "", 0);
            }
            System.out.println(m);

            boolean flag = false;
            for (int c = 0; c < s2.length(); c++){
                if(m.containsKey(s2.charAt(c) + "")){
                    flag = true;
                    break;
                }
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
