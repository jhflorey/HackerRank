package algorithm.strings;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class SherlockAndValidString {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String s = sc.next();
        s = s.replaceAll("\\s+", "");
        s = s.toLowerCase().trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer val = map.get(new Character(c));
            if (val != null) {
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
            }
        }
        checkFrequency(map);
    }

    public static void checkFrequency(Map mp) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Iterator it = mp.entrySet().iterator();

        while (it.hasNext()) {
            Entry pair = (Entry) it.next();
            int value = (int) pair.getValue();
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
            //it.remove(); // avoids a ConcurrentModificationException
        }

        if (map.size() == 1) {
            System.out.println("YES");
        } else {
            if (map.size() == 2) {
                int maxValueInMap = (Collections.max(map.values()));
                int minValueInMap = (Collections.min(map.values()));
                if ( minValueInMap - 1 == maxValueInMap || minValueInMap - 1 == 0 ){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
