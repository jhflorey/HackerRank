package datastructures.arrays.Arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 */
public class SparseArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if (hm.containsKey(str)) {
                int value = hm.get(str);
                hm.put(str, value + 1);
            }else
                hm.put(str, 1);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String str = sc.next();
            if(hm.containsKey(str)){
                System.out.println(hm.get(str));
            }else
                System.out.println(0);
        }

    }
}
