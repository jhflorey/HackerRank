package algorithm.strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 7/02/2016.
 */
public class Gemstones {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int noOfRock = sc.nextInt();

        Set<Character> s1 = new HashSet<>();

        for (int i = 0; i < noOfRock; i++) {
            String str = sc.next();
            if (s1.size() == 0) {
                Character[] c = toCharacterArray(str);
                for(int a = 0 ; a < c.length; a++){
                    s1.add(c[a]);

                }
            }else{
                List<Character> s2 = new ArrayList<>();
                Character[] c = toCharacterArray(str);
                for(int a = 0 ; a < c.length; a++){
                    s2.add(c[a]);
                }
                s1.retainAll(s2);
            }

            if(s1.size() == 0)
                break;
        }

        System.out.println(s1.size());
    }

    public static Character[] toCharacterArray(String sourceString) {
        char[] charArrays = new char[sourceString.length()];
        charArrays = sourceString.toCharArray();
        Character[] characterArray = new Character[charArrays.length];
        for (int i = 0; i < charArrays.length; i++) {
            characterArray[i] = charArrays[i];
        }
        return characterArray;
    }
}
