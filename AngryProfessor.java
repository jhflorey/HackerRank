package algorithm.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * @author Jian
 */
public class AngryProfessor {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("testcase.txt"));
        int noOfTestCases = sc.nextInt();
        for (int a = 0; a < noOfTestCases; a++) {
            int noOfStudents = sc.nextInt();
            int minAttendance = sc.nextInt();
            int times[] = new int[noOfStudents];
            for (int i = 0; i < noOfStudents; i++) {
                times[i] = sc.nextInt();

            }
            if (cancelStatus(times, minAttendance))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    public static boolean cancelStatus(int[] str, int minAttendance) {
        int onTime = 0;
        int notOnTime = 0;
        for (int i = 0; i < str.length; i++) {

            if (str[i] <= 0)
                onTime++;
            if (str[i] > 0)
                notOnTime++;
        }

        if (onTime >= minAttendance)
            return false;
        return true;
    }



}
