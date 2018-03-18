package week_14;


class Seller extends Thread {
	 protected static int i = 0;
	 public Seller() {}
	 public void run() {
	  for (int k = 100; k > 0; k--) {
		  synchronized (this) {
			  if (i < 10) {
				  if (Thread.currentThread().getName().equals("Thread-1")) {
					  System.out.println("´°¿Ú1Âô³öÆ±£ºÆ±ºÅ = " + ++i);
				  } else if (Thread.currentThread().getName().equals("Thread-2")){
					  System.out.println("´°¿Ú2Âô³öÆ±£ºÆ±ºÅ = " + ++i);
				  }
				  else{
					  System.out.println("´°¿Ú3Âô³öÆ±£ºÆ±ºÅ = " + ++i);
				  }
			  } 
			  else {
				  System.exit(0);
			  }
		  }
		  try {
			  Thread.sleep(200);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  	}
	 }
}

public class TestSeller {
	public static void main(String[] args) {
		Seller s = new Seller();
		Thread th1 = new Thread(s);
		Thread th2 = new Thread(s);
		Thread th3 = new Thread(s);
		th1.start();
		th2.start();
		th3.start();
	}
}

