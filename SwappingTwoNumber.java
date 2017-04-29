import java.util.*;

public class SwapingNo {
  public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    System.out.println("Type two no. for swaping");
    System.out.println("enter first no.");
    int n=scn.nextInt();
    System.out.println("enter second no.");
    int m=scn.nextInt();
  
    n=n*m;
    m=n/m;
    n=n/m;
    System.out.println("after swaping 1st no is = "+n);
    System.out.println("after swaping 2nd no. is  = "+m);
  }
}