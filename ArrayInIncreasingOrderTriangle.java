public class PatternForm {
  public static void main(String args[]) {
    int [][]a=new int[5][5];
    a[0][0]=1;
    a[1][1]=2;
    a[2][2]=3;
    a[3][3]=4;
    a[4][4]=5;
    int k=0;
    for(int i=0;i<a.length;i++)
    or(int j=0;j<=i;j++) {
      a[i][j]=k;
      k++;
    }
    for(int i=0;i<a.length;i++) {
      for(int j=0;j<=i;j++) {
        System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
  }
}



// Output : 

// 0
// 1   2
// 3   4    5
// 6   7    8   9
// 10 11 12 13 14
