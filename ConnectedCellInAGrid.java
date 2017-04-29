package algorithm.search;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ConnectedCellInAGrid {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];


        ConnectedCellInAGrid g = new ConnectedCellInAGrid();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }


    }

    public int solve(int[][] grid, int i, int j){
        int count = 0;
        if(grid[i][j] == 0)
            return 0;

        //Get adjacent cells


        return count;

    }
}