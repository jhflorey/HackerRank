package algorithm.strings;

import java.util.*;

public class Pangrams {

    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        final Map<String, Integer> m = new HashMap<String, Integer>();
        int i = 0;
        for (char key : alphabet) {
            m.put(key + "", 0);
        }

        int count = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        str = str.toLowerCase();
        char[] testString = str.toCharArray();
        for (char key : testString) {
            if (m.containsKey(key + "")) {
                m.put(key + "", 1);
            }
        }
        
        boolean flag = true;
        for(String currentKey : m.keySet()){
            if(m.get(currentKey) == 0)
                flag = false;
        }
        
        if(flag)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
        
        


    }

}
