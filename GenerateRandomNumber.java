// An instance of Random class is used to generate a stream of pseudorandom numbers. 
//The class uses a 48-bit seed, which is modified using a linear congruential formula.

// If two instances of Random are created with the same seed, and the same sequence of method calls is made for each, 
//they will generate and return identical sequences of numbers. 
//In order to guarantee this property, particular algorithms are specified for the class Random. 
//Java implementations must use all the algorithms shown here for the class Random, 
//for the sake of absolute portability of Java code. However, 
//subclasses of class Random are permitted to use other algorithms, so long as they adhere to the general contracts for all the methods.


// Many applications will find the method Math.random() simpler to use.



import java.util.*;

public class GenrateRandomNumber {

 public static void main(String[] args) {
  
  Random rand = new Random(System.currentTimeMillis());
  int number ;
  ArrayList<Integer> al=new ArrayList<Integer>();
  for(int i=0; i<10;i++){
   number=rand.nextInt(101);
   al.add(number);
  
 }
  display(al);
 }
 
 static void display(ArrayList arr)
 {
  for(int i=0; i<arr.size(); i++)
   System.out.print(arr.get(i)+" ");
  
 }

}