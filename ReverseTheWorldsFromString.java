import java.util.Scanner;

public class ReverseWordsOfString {
  public static void main(String[] args) {
    System.out.println("Enter your String :");
    Scanner scanobj = new Scanner(System.in); 
    
    char ch;
    char c ;  

    for(;;) {
      String s1 = scanobj.next(); 
      for (int i = 0; i < s1.length(); i++) {
        c = s1.charAt(i);    
      }
      System.out.println();
      for (int x = s1.length()-1; x >= 0; x--) {
        ch = s1.charAt(x);    
        System.out.print(ch);
      }  
    }
  }
}

// Enter your String :
// hello world

// olleh
// dlrow