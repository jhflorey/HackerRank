public class ReverseString {
  public static void main(String[] args) {  
    String s="madam";
    String s1="";  
    for(int i=s.length()-1;i>=0;i--) {   
      s1+=s.charAt(i);   
    }
    System.out.println(s1);  
    if(s.equalsIgnoreCase(s1)) {
      System.out.println(" palindrom");
    } else {
      System.out.println("not palindrom");
    } 
  }
}