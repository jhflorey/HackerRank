// Given a time in -hour AM/PM format, convert it to military (-hour) time.
// Note: Midnight is  on a -hour clock, and  on a -hour clock. Noon is  on a -hour clock, and  on a -hour clock. 
// Input Format
// A single string containing a time in -hour clock format (i.e.:  or ), where  and .
// Output Format
// Convert and print the given time in -hour format, where .


Solution :


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        try{            
                SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ssa");
                SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");

                System.out.println(date24Format.format(date12Format.parse(time)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

// Input (stdin)
// 07:05:45PM
// Your Output (stdout)
// 19:05:45
// Expected Output
// 19:05:45