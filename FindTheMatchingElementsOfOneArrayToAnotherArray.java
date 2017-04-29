// Lets find an element of first array in another array. so lets start from array 1 in which we 
// taking some elements and than take some elements in array 2 . now start for loop for first array and inside
// for loop take another for loop to iterate second arrays elements and in first loop we will iterate elements of first array. 
// now take the if condition inside second for loop to check where elements of first array are same or not 
// as element of second array if elements are same than we will print that element.



import java.util.*;
import java.lang.*;
import java.io.*;


public class Test {
  public static void main (String[] args) throws java.lang.Exception {  
    int arr[]={2,4,5,6,7,8};
    int arr1[] ={9,12,65,6,5,98,7};
    for(int i=0;i<arr.length;i++) {
      for(int j=0;j<arr1.length;j++) {
        if(arr[i]==arr1[j]){
          System.out.print(arr1[j]+" ");
        }
      }
    }
  }
}


// Output : 5  6   7