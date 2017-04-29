// Consumer Producer program is most popular program in threading. here is the solution of the program. 
// UpdateThread class updating the new stock And ConsumeThread class will get the items from the updated stock. 
// if consumer requerd more than the stock so consumer has to wait untill the update thread class will update 
// the new stock. after updating new stock consumer will get the required stock 


class Stock {
  int stock;
  synchronized void update(int n) {
    System.out.println(" updates starts");
    stock+=n;
    System.out.println(" stock update to "+stock);
    notify();
  }
  synchronized void consume(int n) {
    System.out.println(" consume need  : "+n);
    while(n>=stock) {
      System.out.println("stock issue wait for update .....");
      try {
        Thread.sleep(500);
      }
      catch(Exception e) {
        System.out.println(" exception found !!!!");
      }
      try {
        wait();
      }
      catch(Exception e) {
        System.out.println(" Exception occurd !!!!!!");
      }
    }
    stock-=n;
    System.out.println(" consumer used :"+n);
  }
}

class UpdatedThread implements Runnable {
  Stock s;
  int n;
  UpdatedThread(Stock s, int n) {
    this.s=s;
    this.n=n;
    new Thread(this).start();
  }
  public void run() {
    s.update(n);
  }
}
class ConsumeThread implements Runnable {
  Stock s;
  int n;
  ConsumeThread(Stock s, int n) {
    this.s=s;
    this.n=n;
    new Thread(this).start();
  }
  public void run() {
    s.consume(n);
  }
}

public class DeadlockConsumerProducer {
  public static void main(String[] args) {
    Stock s=new Stock();
    // consumer required 18 items those are not in producers stock
    new ConsumeThread(s,18);
    // producer update the stock after this consumer will get 18 items
    new UpdatedThread(s,20);
  }
}












