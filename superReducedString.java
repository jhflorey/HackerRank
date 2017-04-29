// Steve has a string, x, consisting of n lowercase English alphabetic letters. 
// In one operation, he can delete any pair of adjacent letters with same value. 
// For example, string “aabcc” would become either “aab” or “bcc” after operation.

// Steve wants to reduce s as much as possible. To do this, he will repeat the above operation as many times as it can be performed. 
// Help Steve out by finding and printing s‘s non-reducible form!

// Note: If the final string is empty, print Empty String .

// Input Format
// A single string, s.

// Constraints
// 1<=n<=100 Output Format

// If the final string is empty, print Empty String; otherwise, print the final non-reducible string.

// Sample Input 0
// aaabccddd
// Sample Output 0
// abd
// Sample Case 0

// Steve can perform the following sequence of operations to get the final string:

// aaabccddd → abccddd
// abccddd → abddd
// abddd → abd
// Thus, we print abd.

// Sample Input 1
// baab
// Sample Output 1
// Empty String
// Explanation 1

// Steve can perform the following sequence of operations to get the final string:
// baab → bb
// bb → Empty String
// Thus, we print Empty String.

// Sample Input 2
// aa
// Sample Output 2
// Empty String
// Explanation 2

// Steve can perform the following sequence of operations to get the final string:

// aa → Empty String
// Thus, we print Empty String.


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        
        while (true) {
            // Used for loop termination
            int len = s.length();
            
            // "(.)" is a capturing group that captures any character
            // "\\1" is a backreference that will match the character captured by the first capturing group (i.e. the one captured by "(.)")
            s = s.replaceAll("(.)\\1", "");
            
            // If no changes were made to string, break loop
            if( s.length() == len ){
                break;
            }
        }

        System.out.println( (s.isEmpty()) ? "Empty String" : s);
    }
}


// Input (stdin)
// aaabccddd
// Your Output (stdout)
// abd
// Expected Output
// abd