package algorithm.search;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Jian on 3/02/2016.
 */
public class IceCreamParlor {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();

        for (int i = 0; i < noOfTestCases; i++) {
            int money = sc.nextInt();
            int noOfFlavors = sc.nextInt();
            int[] prices = new int[noOfFlavors];
            for (int a = 0; a < noOfFlavors; a++) {
                prices[a] = sc.nextInt();
            }
            solve(prices, money);
        }
    }

    public static void solve(int[] prices, int money) {
        Set set = new HashSet<>(prices.length);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i : prices) {
            int target = money - i;
            count++;
            if (!set.contains(target)) {
                hm.put(i, count);
                set.add(i);
            } else {
                System.out.println(hm.get(target) + " " + count);
                return;
            }
        }
    }
}
