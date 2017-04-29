package algorithm.search;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jian on 3/02/2016.
 */
public class MissingNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int n = sc.nextInt();

        int[] a = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n; i++){
            if(hm.containsKey(a[i])){
                int value = hm.get(a[i]);
                hm.put(a[i], value + 1);
            }else
                hm.put(a[i],1);
        }

        for(int i = 0 ; i < m; i++){
            if(hm.containsKey(b[i])){
                int value = hm.get(b[i]);
                hm.put(b[i], value - 1);
            }else
                hm.put(b[i],1);
        }

        for(Integer i : hm.keySet()){
            if(hm.get(i) < 0)
                System.out.print(i + " ");
        }
    }
}
