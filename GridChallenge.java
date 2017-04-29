package algorithm.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 15/02/2016.
 *
 * The main idea here is to sort each row. After sorting each row, the entire 2d array is passed into another
 * function to check if it is valid.
 */
public class GridChallenge {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int t = sc.nextInt();

        for(int x = 0 ; x < t; x++) {
            int n = sc.nextInt();
            char[][] g = new char[n][n];


            GridChallenge gc = new GridChallenge();

            for (int i = 0; i < n; i++) {
                String string = sc.next();
                for (int j = 0; j < n; j++) {
                    g[i][j] = string.charAt(j);
                }
                Arrays.sort(g[i]);
            }

            if (gc.isValid(g))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public boolean isValid(char[][] g){
        for(int i = 0; i < g.length; i++){
            for(int j = 1; j < g.length; j++){
                if(g[i][j] < g[i][j-1]) {
                    return false;
                }
            }
        }

        for(int i = 1; i < g.length; i++){
            for(int j = 0; j < g.length; j++){
                if(g[i][j] < g[i-1][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public void display(char[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}
