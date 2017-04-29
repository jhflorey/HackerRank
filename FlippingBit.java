package algorithm.bitmanipulation;/*
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
public class FlippingBit {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for(int i = 0 ; i < noOfTestCases; i++){
            System.out.println(flipBit(sc.nextLong()));
        }
    }
    
    public static long flipBit(long value){
        return (long)Integer.MAX_VALUE * 2 + 1 - value;
        
    }
}
