package algorithm.graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Jian on 4/02/2016.
 */
public class GreedyFlorist {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noToPurchase = sc.nextInt();
        int sizeOfGroup = sc.nextInt();

        ArrayList<Integer> prices = new ArrayList<>();
        for( int i = 0; i < noToPurchase; i++){
            prices.add(sc.nextInt());
        }

        int[] purchases = new int[sizeOfGroup];
        Arrays.fill(purchases, 0);

        Collections.sort(prices, Collections.reverseOrder());

        int totalPrice = 0;
        while (noToPurchase != 0){
            Arrays.sort(purchases);
            int currentPrice = (purchases[0] + 1) * prices.get(0);
            purchases[0] = purchases[0] + 1;
            totalPrice += currentPrice;
            noToPurchase--;
            prices.remove(0);
        }

        System.out.println(totalPrice);
    }
}
