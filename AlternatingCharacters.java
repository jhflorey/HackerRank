package algorithm.strings;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Jian
 */
public class AlternatingCharacters {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int a = 0; a < noOfTestCases; a++) {
            String str = sc.next();
            solve(str);
        }

    }

    public static void solve(String str){
        char[] c = str.toCharArray();

        int count = 0;
        for(int i = 1; i < c.length; i++){
            if(c[i] == c[i-1])
                count++;
        }

        System.out.println(count);
    }
}
