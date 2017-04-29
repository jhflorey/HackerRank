/**
 * Created by yuantian on 4/28/14.
 */

/*
    see PlayGameRecurseive for the problem
* */
import java.util.*;

public class PlayGame {

    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            long[] brick = new long[n];
            for(int i = 0; i < n; i++) {
                brick[i] = in.nextLong();
            }

            long[] min = new long[n+1];
            long[] max = new long[n+1];

            for(int i = n-1; i >= n-3; i--) {
                max[i] = max[i+1] + brick[i];
            }

            for(int i = n-4; i>= 0; i--) {
                max[i] = getMax(brick[i] + min[i+1],
                        brick[i] + brick[i+1] + min[i+2],
                        brick[i] + brick[i+1] + brick[i+2] + min[i+3]);
                min[i] = getMin(max[i+1], max[i+2], max[i+3]);
            }

            System.out.println(max[0]);
        }
    }

    static private long getMax(long l1, long l2, long l3) {
        return Math.max(l1, Math.max(l2, l3));
    }

    static private long getMin(long l1, long l2, long l3) {
        return Math.min(l1, Math.min(l2, l3));
    }

}
