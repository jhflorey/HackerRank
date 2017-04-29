package algorithm.bitmanipulation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class LonelyInteger {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int noOfInts = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;

        for (int i = 0; i < noOfInts; i++) {
            //list.add(sc.nextInt());
            a ^= sc.nextInt();
        }
        
        //Integer[] unique = new HashSet<>(list).toArray(new Integer[0]);

        //System.out.println(unique[unique.length - 1]);
        System.out.println(a);



    }
}
