package algorithm.strings;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.util.regex.Matcher;

/**
 * @author Jian
 */
public class TwoTwo {

    static Map<String, HashSet> map;

    public static int strength(int i, int j) {
        return 0;
    }

    public static void findSubString(String input){
        HashSet<String> infixes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) != '0') {
                    infixes.add(input.substring(i, j));
                }
            }
        }
        System.out.println(infixes);

    }



    public static void main(String[] args) {

        String input = "Harry";

        findSubString("ABCD");
        findSubString("ABDC");

//        int highest = Integer.highestOneBit(Integer.parseInt(input) - 1);
//        int value = (int) (Math.log(highest) / Math.log(2));

//        if (value >= 800)
//            value = 800;
//
//
//        ArrayList<String> power = new ArrayList<>();
//
//        int result = 0;
//
//        for (int i = 1; i <= value; i++) {
//            result = (int) Math.pow(2, i);
//            power.add(result + "");
//        }

//        int lengthToScan = (int) Math.log10(highest) + 1;

        //Find substring of string
        //System.out.println(map);


    }
}

