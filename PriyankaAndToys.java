package algorithm.greedy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Jian on 6/02/2016.
 */
public class PriyankaAndToys {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfToys = sc.nextInt();
        ArrayList<Integer> weights = new ArrayList<>();

        for (int i = 0; i < noOfToys; i++) {
            weights.add(sc.nextInt());
        }

        Collections.sort(weights);

        int x = weights.get(0);
        int y = x + 4;
        int c = 1;

        for (int i = 0; i < noOfToys; i++) {
            if (weights.get(i) >= x && weights.get(i) <= y)
                continue;
            else {
                c++;
                x = weights.get(i);
                y = x + 4;
            }
        }

        System.out.println(c);

    }
}