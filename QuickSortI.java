package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jian on 14/02/2016.
 */
public class QuickSortI {

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        int arr[] = new int[n];

        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < n; i++){
            //arr[i] = sc.nextInt();
            values.add(sc.nextInt());
        }



        quickSort(values);
        System.out.println(result);


    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> values){
        if(values.size() == 0 || values.size() ==1)
            return values;

        Integer pivot = values.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();


        equal.add(pivot);

        for(int i = 1; i < values.size(); i++){
            if(values.get(i) >= pivot)
                right.add(values.get(i));
            else
                left.add(values.get(i));
        }

        System.out.println(left + " " + equal + " " + right);

        left = quickSort(left);
        right = quickSort(right);


        return values;
    }
}
