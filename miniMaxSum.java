// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
// Then print the respective minimum and maximum values as a single line of two space-separated long integers.

// Input Format

// A single line of five space-separated integers.

// Constraints

// Each integer is in the inclusive range .
// Output Format

// Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by 
// summing exactly four of the five integers. 
// (The output can be greater than 32 bit integer.)

// Sample Input

// 1 2 3 4 5
// Sample Output

// 10 14
// Explanation

// Our initial numbers are , , , , and . We can calculate the following sums using four of the five integers:

// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// If we sum everything except , our sum is .
// As you can see, the minimal sum is  and the maximal sum is . 
// Thus, we print these minimal and maximal sums as two space-separated integers on a new line.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;mport java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long sum = 0;
        long min = 1000000000;
        long max = 0;
        while(scan.hasNext()) {
            long n = scan.nextLong();
            sum = sum + n;
            if (min > n) {
                min = n;
            }
            if (max < n) {
                max = n;
            }
        }
        scan.close();
        
        System.out.println((sum - max) + " " + (sum - min));
    }
}

// Input (stdin)
// 1 2 3 4 5
// Your Output (stdout)
// 10 14
// Expected Output
// 10 14

