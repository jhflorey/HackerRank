package algorithm.implementation;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jian
 */
public class CutTheSticks {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("testcase.txt"));
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        insertionSort(arr);
        int i = 0;

        for (i = 0; i < arr.length; i++) {
            int count = 0;
            int min = arr[i];
            if (min > 0) {
                for (int j = 0; j < arr.length; j++) {

                    if (arr[j] > 0) {
                        arr[j] = arr[j] - min;
                        count++;
                    }
                }
                System.out.println(count);
            }
        }

    }

    public static void insertionSort(int[] arr) {
        int i, j, newValue;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
    }
}
