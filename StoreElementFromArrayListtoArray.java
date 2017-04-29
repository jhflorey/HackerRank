// Convert an ArrayList To an Array is a most common question and somtimes we need to store an arraylist elements in an array . 
// to convert an ArrayList to an array a method present in Collection fraimwork  toArray() .
// In this program first  i am creating an arraylist than printing that ArrayList .al is the refrance of ArrayList.
// than taking on Object[] to store the elements of ArrayList in the array than using toArray() method converting ArrayList to Array .


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListToArray {

  public static void main(String[] args) {
  
    List al=new ArrayList();
    
    al.add(5);
    al.add("abc");
    al.add(65);
    al.add('x');
  
    Iterator itr=al.iterator();
    while(itr.hasNext()) {
      System.out.println(itr.next());
    }
    System.out.println(" after changing to array");
    Object[] ar=al.toArray();
    for(Object a:ar) {
      System.out.println(a);
    }
  }
}
