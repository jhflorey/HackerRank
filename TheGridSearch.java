package algorithm.implementation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jian
 */
import java.util.*;

public class TheGridSearch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numcase = in.nextInt(), len = 0, wid = 0, sindex = 0, lindex = 0;
        String[] bigarray, smallarray;
        boolean found = false;
        for (int x = 0; x < numcase; x++) {
            sindex = 0;
            lindex = 0;
            found = false;
            len = in.nextInt();
            wid = in.nextInt();
            bigarray = new String[len];
            for (int y = 0; y < len; y++) {
                bigarray[y] = in.next();
            }
            len = in.nextInt();
            wid = in.nextInt();
            smallarray = new String[len];
            for (int y = 0; y < len; y++) {
                smallarray[y] = in.next();
            }
            for (int y = 0; y < bigarray.length; y++) {
                if (bigarray[y].contains(smallarray[0])) {
                    sindex = bigarray[y].indexOf(smallarray[0]);
                    lindex = sindex + smallarray[0].length() + 1;
                    found = true;
                    for (int z = 1; z < smallarray.length; z++) {
                        //System.out.println(bigarray[y+z].substring(sindex, lindex));
                        if (!bigarray[y + z].substring(sindex, lindex).contains(smallarray[z])) {
                            found = false;
                        }
                    }
                }
                if (found == true) {
                    break;
                }
            }
            if (found == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
