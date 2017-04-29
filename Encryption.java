package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class Encryption {

    public static int MAXIMUM_LENGTH = 81;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        String str = "";
        while (sc.hasNext()) {
            str += sc.next();
        }

        str = str.replaceAll("\\s+", "");
        int length = str.length();

        double rows = Math.floor(Math.sqrt((double) length));
        double cols = Math.ceil(Math.sqrt((double) length));

        String s = "";
        
        for(int r = 0 ; r <= rows; r++){
            for (int i = r; i < str.length(); i += cols) {
                s += str.charAt(i); 
            }
            s += " ";
            if(s.length() > length+r)
                break;
        }
        System.out.println(s);

    }

}
