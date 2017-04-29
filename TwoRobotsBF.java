package weekofcode19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Jian on 17/02/2016.
 *
 * Current solution is ((2 ^ N)/2) * N/2
 */
public class TwoRobotsBF {

    static LinkedHashMap<String, Map<String, Integer>> hm = new LinkedHashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("testcase.txt"));

        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {

            hm.clear();
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            int noOfContainers = sc.nextInt();
            int queries = sc.nextInt();
            int[] mA = new int[queries];
            int[] mB = new int[queries];

            for (int i = 0; i < queries; i++) {
                mA[i] = sc.nextInt();
                mB[i] = sc.nextInt();
            }



            //char[] moves= {'0','1','1','0'};
            //System.out.println(distanceSoFar(mA,mB, moves));



            int value = queries;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < (Math.pow(2, value)/2) ; i++) {
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(i));
                for (int j = binary.length(); j < value; j++) {
                    binary.insert(0, '0');
                }

                int distance = distanceSoFar(mA, mB, binary.toString().toCharArray());

                map.put(distance + "", binary.toString());
                min = Math.min(min, distance);
            }

            System.out.println("Min is " + min + " : " + map.get(min + ""));
            System.out.println(min);

            hm.clear();

        }
    }


    public static int distanceSoFar(int[] mA, int[] mB, char[] moves) {
        int distance = 0;
        int r1Pos = 0;
        int r2Pos = 0;

        for (int i = 0; i < moves.length; i++) {
            if (i < moves.length) {
                if (moves[i] == '0') {
                    if (r1Pos != 0)
                        distance += Math.abs(r1Pos - mA[i]);
                    distance += Math.abs(mA[i] - mB[i]);
                    r1Pos = mB[i];
                }
                if (moves[i] == '1') {
                    if (r2Pos != 0) {
                        distance += Math.abs(r2Pos - mA[i]);
                    }
                    distance += Math.abs(mA[i] - mB[i]);
                    r2Pos = mB[i];
                }
            }
        }
        return distance;
    }
}
