// String class is immutable class in java . once we create the object of the immutable class we c'nt change that object.
// When one object is shared with others and when the value of the object is changed so others also will be affected. 
// To overcome this problem immutable is solution.
// When we create the string class object we can't change that object if we will try so that time one new object 
// will be created and the reference of current object will point to new object and than old object will be abandon 
// and eligible for garbage collector.

// We can Make our own immutable class .

final class MakeImutableClass {
  final String panCardNo;
  public MakeImutableClass(String panCardNo) {
    this.panCardNo=panCardNo;
  }
  public String getPanCardNo() {  
    return panCardNo;
  }
}

public class ImmutableClass {
  public static void main(String[] args) {
    MakeImutableClass mic=new MakeImutableClass("first");
    MakeImutableClass mic1=new MakeImutableClass("second");
  
  
    System.out.println("first pan no. is "+mic.getPanCardNo());
    System.out.println("second pan no. is " +mic1.getPanCardNo()); 
  }
}