package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Jian on 28/01/2016.
 */
public class ManasaAndStones {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int x = 0; x < noOfTestCases; x++) {
            Set<Integer> sol = new HashSet<>();

            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int i = 0; i < n; i++) {
                sol.add(a*(n-i-1) + b*i);
            }

            for(Integer i : sol){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
