package algorithm.sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 15/02/2016.
 */
public class CountingSort3 {
    public static void main(String[] args) throws FileNotFoundException {

        Map<Integer, StringBuilder> map = new HashMap<Integer,StringBuilder>();
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {

            int val = sc.nextInt();
            String str = sc.next();

            if(i < n / 2) {
                str = "-";
            }

            if(map.containsKey(val)) {
                map.get(val).append(" " + str);
            } else {
                map.put(val, new StringBuilder(str));
            }

        }

        List<Integer> al = new ArrayList<Integer>(map.keySet());
        Collections.sort(al);

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < al.size(); i++) {
            result.append(map.get(al.get(i)) + " ");
        }

        System.out.println(result.toString());


    }

}

