package algorithm.greedy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 2/02/2016.
 */
public class MarkAndToys {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int n = sc.nextInt();
        int k = sc.nextInt();
        int []prices = new int[n];

        for(int i = 0; i < n;i++){
            prices[i] = sc.nextInt();
        }

        Arrays.sort(prices);

        int i = 0;
        while( k > 0){
            k = k - prices[i];
            i++;
        }

        System.out.println((i-1));

    }
}
