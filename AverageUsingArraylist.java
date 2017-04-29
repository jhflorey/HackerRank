import java.util.*;

public class ArrayListForAverage {
  public static void main(String[] args) {
    double average;
    int total=0;
    ArrayList<Integer> al=new ArrayList<Integer>();
    al.add(56);
    al.add(75);
    al.add(83);
    al.add(82);
    al.add(82);
    for(int i=0; i<al.size(); i++) {
      total+=al.get(i);
    }
    average=total/al.size();
    System.out.println("average is =" +average );
  
    ArrayList<Integer> al1=new ArrayList<Integer>();
    for(int i=0;i<=10; i++) {
      al1.add(i);
      System.out.println(i);
    }
    System.out.println("size of array is = "+al1.size());
  }
}