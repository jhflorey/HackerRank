package algorithm.implementation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class LibraryFine {
    
    public static int calculateFine(Date a, Date e){
        if(a.getYear() > e.getYear()) {
            System.out.println(a.getYear() - e.getYear());
            return 10000;
        }
        if(a.getYear() < e.getYear())
            return 0;
        if(a.getMonth() > e.getMonth())
            return (a.getMonth() - e.getMonth()) * 500;
        if(a.getMonth() < e.getMonth())
            return 0;
        if(a.getDay() > e.getDay())
            return (a.getDay() - e.getDay()) * 15;
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int aD = sc.nextInt();
        int aM = sc.nextInt();
        int aY = sc.nextInt();
        Date d1 = new Date(aY, aM, aD);

        int eD = sc.nextInt();
        int eM = sc.nextInt();
        int eY = sc.nextInt();

        Date d2 = new Date(eY, eM, eD);


        
        System.out.println(calculateFine(d1, d2));

    }
}
