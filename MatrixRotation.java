package algorithm.implementation;

import java.io.*;
import java.util.*;

public class MatrixRotation {

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int m = sc.nextInt();
        int n = sc.nextInt();

        int rotation = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m * n; i++) {
            list.add(sc.nextInt());
        }

        rotateList(list, m, n, rotation, n);
        displayResult(result, m, n);
    }


    public static ArrayList<Integer> swap(ArrayList<Integer> list, int times, int column) {
        if (list.size() == 1) {
            return list;
        }
    
        int smallestRotation = (times % list.size());
        
        for (int a = 0; a < smallestRotation; a++) {
            for (int i = 0; i < list.size() - 1; i++) {
                Collections.swap(list, i, i + 1);
            }
        }
        result.addAll(list);
        return list;
    }

    // Recursively obtain all the outer values in swap them depending on rotation
    public static void rotateList(ArrayList<Integer> matrix, int m, int n, int rotation, int columnSize) {
        if (m == 0 || n == 0) {
            return;
        }

        ArrayList<Integer> al = new ArrayList<>();
        int size = m * n;
        ArrayList<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(matrix.get(i));
            indexs.add(i);
        }

        for (int i = n + n; i <= size - n; i = i + n) {
            al.add(matrix.get(i - 1));
            indexs.add(i - 1);
        }

        for (int i = size - 1; i >= size - n; i--) {
            al.add(matrix.get(i));
            indexs.add(i);
        }

        for (int i = (size - n - n); i >= n; i = i - n) {
            al.add(matrix.get(i));
            indexs.add(i);
        }

        Collections.sort(indexs, Collections.reverseOrder());
        for (int i : indexs) {
            matrix.remove(i);
        }

        if (al.size() != 1) 
            swap(al, rotation, columnSize);
        rotateList(matrix, m - 2, n - 2, rotation, columnSize);
    }

    // Filling up the matrix in a circular pattern
    public static void displayResult(ArrayList<Integer> result, int m, int n) {
        int[][] spiral = new int[m][n];
        int value = 0;
        int minCol = 0;
        int maxCol = n - 1;
        int minRow = 0;
        int maxRow = m - 1;

        while (value < result.size()) {
            for (int i = minCol; i <= maxCol; i++) {
                spiral[minRow][i] = result.get(value++);
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                spiral[i][maxCol] = result.get(value++);
            }

            for (int i = maxCol - 1; i >= minCol; i--) {
                spiral[maxRow][i] = result.get(value++);
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                spiral[i][minCol] = result.get(value++);;
            }

            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spiral[i][j] + " ");
            }
            System.out.println();
        }
    }

}
