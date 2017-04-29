// A matrix which is formed by turning all the rows of a given matrix into columns and vice-versa. The transpose of matrix A is written AT.


public class TransposeMatrix  {
  public static void metrix(int[] arr, int j) {
    for(int i=0;i<arr.length;i++) {
      if((i+1)%j==1) {
        System.out.println();
      }
      System.out.print(" "+arr[i]);
    }
    System.out.println(" transpose matrix");
  }
  public static void main(String[] args) {
    int [] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    int j=2;
    metrix(a,j);
  }

}


// Output :
// 1 2
//  3 4
//  5 6
//  7 8
//  9 10
//  11 12
//  13 14
//  15 16 transpose matrix
