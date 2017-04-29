package algorithm.greedy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Jian on 15/02/2016.
 *
 * The idea for this solution is to add up the time the order was placed and the time
 * it takes to process the order. After that sort them based on that time.
 */
public class JimAndTheOrders {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int n = sc.nextInt();
        int[][] fanProcess = new int[n][2];
        Map<Integer, Integer> order = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                fanProcess[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            order.put(i + 1, fanProcess[i][0] + fanProcess[i][1]);
        }

        order = JimAndTheOrders.sortByValue(order);

        for (Integer integer : order.keySet()) {
            System.out.print(integer + " ");
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getValue()))
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }
}
