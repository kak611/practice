import java.util.*;

// http://tutorials.jenkov.com/java-concurrency/race-conditions-and-critical-sections.html
// https://www.netjstech.com/2015/06/race-condition-in-java-multi-threading.html
class SharedObject {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread(counter, "T1");
		Thread t2 = new Thread(counter, "T2");
		Thread t3 = new Thread(counter, "T3");

		t1.start();		
		t2.start();		
		t3.start();				
	}

	static class Counter implements Runnable {
		private int count = 0;

		public synchronized void increment() {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count += 1;
		}

		public void decrement() {
			count -= 1;			
		}

		public int getCount() {
			return count;
		}

		public void run() {
			// synchronized(this) {
				String t = Thread.currentThread().getName();
				increment();
				System.out.println("This is thread " + t + " after increment value " + getCount());
				decrement();			
				System.out.println("This is thread " + t + " after decrement value " + getCount());
			// }
		}
	}

}
