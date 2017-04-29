package weekofcode19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 16/02/2016.
 */
public class FixTheCycle {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int[] values = new int[3];

        // We know that there are 3 simple cycles in this graph
        values[0] = b + c + d + a;
        values[1] = e + d + a;
        values[2] = b + f + a;

        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i = 0; i < values.length; i++){
            if(values[i] < 0){
                if(values[i] < min){
                    min = values[i];
                }
            }else{
                count++;
            }
        }

        if(count == 3){
            System.out.println(0);
        }else{
            System.out.println(Math.abs(min));
        }

    }

}

