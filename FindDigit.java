package algorithm.implementation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class FindDigit {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int noOfTestCases = sc.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            int value = sc.nextInt();
            System.out.println(solve(value));
        }

    }

    public static int[] makeArray(int value) {
        String temp = Integer.toString(value);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }

        return newGuess;
    }

    public static int solve(int value) {
        //First break down the value into an array.
        int[] arr = makeArray(value);
        
        int count = 0;
        //System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            //System.out.println(value);
            if (arr[i] != 0) {
                if (value % arr[i] == 0) {
                    count++;
                }
            }
        }
        System.out.println("");
        return count;
    }
}
