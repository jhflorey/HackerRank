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
public class SherlockAndSquares {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();
        for(int i = 0 ; i < noOfTestCases; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            double sum = Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1;
            System.out.println((int)sum );
        }
        
    }
}
