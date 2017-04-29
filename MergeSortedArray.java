/**
 * Created with IntelliJ IDEA.
 * User: Michael
 * Date: 3/7/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int next = n + m - 1;
        int i1 = m - 1, i2 = n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (A[i1] > B[i2]) {
                A[next--] = A[i1--];
            } else {
                A[next--] = B[i2--];
            }
        }

        while (i2 >= 0) {
            A[next--] = B[i2--];
        }
    }
}
