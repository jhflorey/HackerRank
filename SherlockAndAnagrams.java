package algorithm.strings;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class SherlockAndAnagrams {

    public static void solve(String s) {
        int length = s.length();
        int count = 0;
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        Map<String, Integer> elementCount = new HashMap<String, Integer>();
        for (int j = 1; j < length; j++) {
            for (int k = 0; k < length - (j - 1); k++) {
                String st = s.substring(k, k + j);
                char[] cr = st.toCharArray();
                Arrays.sort(cr);
                String subString = new String(cr);
                if (myMap.containsKey(subString)) {
                    int n = myMap.get(subString);
                    int p = elementCount.get(subString);
                    if (n == 0) {
                        n = n + 1;
                        p += 1;
                    } else {
                        n = n + p;
                        p += 1;
                    }
                    myMap.put(subString, n);
                    elementCount.put(subString, p);
                } else {
                    myMap.put(subString, 0);
                    elementCount.put(subString, 1);
                }
            }
        }
        for (String key : myMap.keySet()) {
            count = count + myMap.get(key);
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("testcase.txt"));
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String s = in.next();
            solve(s);

        }

    }
}
