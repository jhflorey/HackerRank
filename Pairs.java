package algorithm.search;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Jian on 3/02/2016.
 */
public class Pairs {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        HashSet<Integer> hs = new HashSet<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            hs.add(sc.nextInt());
        }

        solve(k, hs);

    }

    // All n numbers are unique
    public static void solve(int k, HashSet hs) {
        int count = 0;
        Set<Integer> set = new HashSet<>(hs);

        for(Integer i : set) {
            int target = k + i;
            if (set.contains(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
