package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 * Initially thought it needed all its neighbours but apparently no.
 */
public class CavityMap {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int size = sc.nextInt();
        String str = "";

        for (int i = 0; i < size; i++) {
            str += sc.next().trim();
        }

        ArrayList<Integer> sideGrids = new ArrayList<>();
        int left = 0;
        int right = size - 1;

        for (int i = 0; i < size; i++) {
            sideGrids.add(left);
            sideGrids.add(right);
            left += size;
            right += size;
        }

        ArrayList<Integer> positions = new ArrayList<>();

        outer_loop:
        for (int i = size + 1; i < (str.length() - size); i++) {
            String values = "";
            if (!sideGrids.contains(i)) {
                //values += (str.substring(i - size - 1, (i - size - 1) + 3));
                values += str.substring(i - size, i - size + 1);
                values += str.substring(i - 1, i);
                values += str.substring(i + 1, i + 2);
                values += str.substring(i + size, i + size + 1);
                //values += str.substring(i + size - 1, (i + size - 1) + 3);

                for (int a = 0; a < values.length(); a++) {
                    if (Character.getNumericValue(str.charAt(i)) <= Character.getNumericValue(values.charAt(a))) {
                        continue outer_loop;
                    }
                }
                positions.add(i);
            }
        }

        StringBuilder results = new StringBuilder(str);
        for (Integer i : positions) {
            results.setCharAt(i, 'X');
        }


        System.out.println(results.toString().replaceAll("(.{" + size + "})", "$1\n"));
    }
}
