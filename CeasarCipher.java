package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Jian on 28/01/2016.
 */
public class CeasarCipher {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int length = sc.nextInt();
        String s = s = sc.next();
        int rotations = sc.nextInt();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        Map<String, String> m1 = hashMapRotate(alphabet, rotations);
        Map<String, String> m2 = hashMapRotate(alphabetBig, rotations);

        m1.putAll(m2);

        System.out.println(m1);
        for (int i = 0; i < length; i++) {
            if (m1.containsKey(s.charAt(i) + "")) {
                System.out.print(m1.get(s.charAt(i) + ""));
            } else {
                System.out.print(s.charAt(i));
            }
        }
    }


    public static Map hashMapRotate(char[] array, int rotation) {
        char[] alphabet = new char[array.length];
        char[] moveArray = new char[array.length];

        System.arraycopy(array, 0, alphabet, 0, array.length);
        System.arraycopy(array, 0, moveArray, 0, array.length);

        //Smallest rotation is when the cipher returs back to original
        if (rotation > (alphabet.length - 1))
            rotation = rotation % alphabet.length;

        for (int j = 0; j < rotation; j++) {
            char start = moveArray[0];
            System.arraycopy(moveArray, 1, moveArray, 0, moveArray.length - 1);
            moveArray[moveArray.length - 1] = start;
        }

        final Map<String, String> m = new HashMap<String, String>();
        for (int i = 0; i < alphabet.length; i++)
            m.put(alphabet[i] + "", moveArray[i] + "");
        return m;
    }
}
