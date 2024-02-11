import java.util.concurrent.Semaphore;

public class HW3 {

	public static class MyThread extends Thread {
		
		private static final Semaphore semaphore = new Semaphore(1);;
		private static char currentThread = 'A';
		private boolean racer = false;
		private char name;
		
		public MyThread(char name)
		{
			this.name = name;
		}
		
		@Override
		public void run() {
			while(true)
	        {	
				try 
				{

					 if (racer || name == currentThread ) 
					 {
						 semaphore.acquire();
					
	                        
	                        for (int i = 1; i <= 20; i++) {
	                            Thread.sleep(5);
	                            System.out.println("Thread " + name + " " + i);
	                        }
	                        
	                        if (currentThread == 'A') {
	                            currentThread = 'B';
	                        } else if (currentThread == 'B') {
	                        	if(name == 'B') {
	                        		racer = true;
	                        	}
	                        	currentThread = 'C';
	                        } else if(currentThread == 'C')
	                        {
	                            currentThread = 'A';
	                            if(name == 'B')
	                        		racer = false;
	                        }
	                        
	                        
	                        semaphore.release();
	                    }
					 else
						 Thread.sleep(100);
				}
					
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        }
	    }
	 }
	
	public static void main(String[] args) {
		Thread t1 = new MyThread('A');
		Thread t2 = new MyThread('B');
		Thread t3 = new MyThread('C');
		t1.start();
		t2.start();
		t3.start();
		

	}

}
