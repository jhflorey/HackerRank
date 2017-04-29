package weekofcode19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ScalarProducts {

    static HashMap<Long, Long> hm = new HashMap<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int length = 2 * n + 2;
        int[] sequence = new int[length];

        sequence[0] = 0;
        sequence[1] = a1;

        HashMap<Integer, Integer> sumHash = new HashMap<>();


        for (int i = 2; i < length; i++) {
            int sum = sequence[i - 1] + sequence[i - 2];
            if (!sumHash.containsKey(sum)) {
                int modSum = sum % m;
                sequence[i] = modSum;
                sumHash.put(sum, sequence[i]);
            } else {
                sequence[i] = sumHash.get(sum);
            }
        }

        long[][] ve = new long[(length / 2) - 1][2];
        int count = 0;
        for (int i = 2; i < length; i = i + 2) {
            ve[count][0] = sequence[i];
            ve[count][1] = sequence[i + 1];
            count++;
        }

        HashSet<Long> result = new HashSet<>();


        for (int i = 0; i < ve.length; i++) {
            for (int j = i + 1; j < ve.length; j++) {
                long product = scalarProduct(ve[i][0], ve[i][1], ve[j][0], ve[j][1]);
                if (!hm.containsKey(product)) {
                    long r = product % m;
                    hm.put(product, r);
                    result.add(r);
                }
            }
        }
        System.out.println(hm.getOrDefault(result.size(), (long) result.size() % m));

    }

    public static long scalarProduct(long p1x, long p1y, long p2x, long p2y) {
        return p1x * p2x + p1y * p2y;
    }
}

