package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Jian on 28/01/2016.
 */
public class ChocolateFeast {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));

        int no = sc.nextInt();

        for(int i = 0 ; i < no; i++){
            long inPocket = sc.nextLong();
            long price = sc.nextLong();
            long wrapper = sc.nextLong();

            solve(inPocket,price, wrapper);

        }
    }

    public static void solve(long inPocket, long price, long m){
        long noOfChoc = 0;
        noOfChoc = inPocket / price;
        long wrapperCount =  noOfChoc;
        long free = 0;

        while (wrapperCount >= m){
            free = wrapperCount/m;
            noOfChoc = noOfChoc + free;
            wrapperCount = free + wrapperCount%m;
        }


        System.out.println(noOfChoc);
    }
}
