import java.util.Scanner;


class Emp {
  int id;
  String name;
   
  Emp(int i, String n) {
    id=i;
    name=n;
  }
  public void display() {
    System.out.println(id+"\t"+name);
  }
}
public class PrintempDetail {
  public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    System.out.println("type size ");
    int  n=scn.nextInt();
    
    Emp [] arr=new Emp[n];
    for(int i=0;i<n;i++) {
      System.out.print("enter id :");
      int id=scn.nextInt();
      System.out.print("Enter name :");
      String name=scn.next();
      arr[i]=new Emp(id, name);
    }
  
    System.out.println("\nThe employee  data is");
    for(int i=0;i<arr.length;i++) {
      arr[i].display();
    }
  }
}

// Output :

// type size
// 2
// enter id :1
// Enter name :hari
// enter id :2
// Enter name :jay

// The employee  data is
// 1 hari
// 2 jay
