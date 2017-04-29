// A string is said to be complete if it contains all the characters from a to z. Given a string, check if it complete or not.
// Input
// First line of the input contains the number of strings N. It is followed by N lines each contains a single string.
// Output
// For each test case print "YES" if the string is complete, else print "NO"
// Constraints
// 1 <= N <= 10
// The length of the string is at max 100 and the string contains only the characters a to z

// Sample Input (Plaintext Link)

// 3
// wyyga
// qwertyuioplkjhgfdsazxcvbnm
// ejuxggfsts

// Sample Output (Plaintext Link)

// NO
// YES
// NO


import java.util.Scanner;

public class CompleteString {
  public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int s=scn.nextInt();
    String [] str=new String[s];
    for(int i=0;i<str.length;i++) {
      str[i]=scn.next();
    }
    for(String ns:str) {
      fltr(ns);
    }
  
  }
  public static void fltr(String str) {
    String s=str.replaceAll(" ", "");
    String s1="";
    String s2="";
  
    for(char j='a';j<='z';j++) {
      s2+=j;
    }
    for(int i=0;i<s.length();i++) {
      char c=Character.toLowerCase(s.charAt(i));
      if(s1.indexOf(c)==-1) {
        s1+=c;
      }      
     
    }
    
    if(s1.length()==s2.length()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}





