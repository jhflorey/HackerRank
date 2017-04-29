package algorithm.greedy;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 1/02/2016.
 */
public class SherlockAndMiniMax {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

        int size = Integer.parseInt(br.readLine());
        int []a = new int[size];
        String []inputs = br.readLine().split(" ");
        for(int i = 0 ; i < size; i++){
            a[i] = Integer.parseInt(inputs[i]);
        }

        String []pq = br.readLine().split(" ");

        int p = Integer.parseInt(pq[0]);
        int q = Integer.parseInt(pq[1]);

        Arrays.sort(a);

        List<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i + 1 < size; i++) {
            if ((a[i] + a[i + 1]) % 2 == 0)
                al.add((a[i] + a[i + 1]) / 2);
            else {
                al.add((a[i] + a[i + 1]) / 2);
                al.add((a[i] + a[i + 1]) / 2 + 1);
            }
        }

        al.add(p);
        al.add(q);
        Collections.sort(al);

        int max = 0;
        int result = 0;

        for(int i : al){
            if( i >= p && i <= q){
                int value = calculate(a,i);
                if(value > max) {
                    max = value;
                    result = i;
                }
            }
        }
        System.out.println(result);
    }



    public static int calculate(int[] a, int m){
        int []minValues = new int[a.length];
        for(int i = 0; i < a.length; i++){
            minValues[i] = Math.abs(a[i] - m);
        }
        Arrays.parallelSort(minValues);
        return minValues[0];
    }

}
