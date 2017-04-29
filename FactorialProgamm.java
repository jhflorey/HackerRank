// Factorials are very simple things. They're just products, indicated by an exclamation mark. 
// For instance, "four factorial" is written as "4!" and means 1×2×3×4 = 24. 
// In general, n! ("enn factorial") means the product of all the whole numbers from 1 to n; that is, n! = 1×2×3×...×n.



import java.util.Scanner;

public class Factorial {
     public static void main(String[] args) {
      Scanner scn =new Scanner(System.in);
      System.out.println("enter a no. to find factorial");
      int n=scn.nextInt();
      int fact=1;
      for(int i=1;i<=n;i++) {
        fact=fact*i;
      }
      System.out.println("factorial of "+n+" is ="+fact); 
    }
}



// Factorial Using Recursion

public class FactorialRecursion {
  public static void main(String[] args) {
    int n=5;
    System.out.println(fact(n));
  }
  public static int fact(int n) {
    if(n<=1)
    return 1;
    else
    return n*fact(n-1);
  }
}
