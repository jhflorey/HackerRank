package util;

/**
 * Created by Jian on 12/02/2016.
 */
public class Permutation {

    static void swap(char a[], int l, int r) {
        char temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    static void permute(char a[], int l, int r) {
        if (l == r)
            System.out.println(getString(a));
        else {
            for (int i = l; i <= r; i++) {
                swap(a, l, i);
                permute(a, l + 1, r);
                swap(a, l, i); // backtrack
            }
        }
    }

    static String getString(char a[]) {
        StringBuffer str = new StringBuffer();
        for (char c : a) {
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String inputString = "ABC";
        char str[] = inputString.toCharArray(); // convert input string into
        // char array
        int n = str.length;
        permute(str, 0, n - 1);
    }

}
