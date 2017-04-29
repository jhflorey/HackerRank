package algorithm.strings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 */
public class MakeItAnagram {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        String s1 = sc.next();
        String s2 = sc.next();

        final HashMap<String, Integer> m1 = new HashMap<>();

        for (int x = 0; x < s1.length(); x++) {
            String key = s1.charAt(x) + "";
            if (m1.containsKey(key)) {
                int value = m1.get(key);
                m1.put(key, value + 1);
            } else
                m1.put(key, 1);
        }

        // -1 because character occurred.
        for (int x = 0; x < s2.length(); x++) {
            String key = s2.charAt(x) + "";
            if (m1.containsKey(key)) {
                int value = m1.get(key);
                m1.put(key, value - 1);
            } else
                m1.put(key, -1);
        }

        int sum = 0;
        for (Integer m : m1.values()) {
            sum += Math.abs(m);

        }

        System.out.println(sum);

    }
}
