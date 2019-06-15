package practice.findverma.codehub.thread_codes;

class EvenOddPrintJob implements Runnable {
	private Object lock;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public EvenOddPrintJob(int reminder, Object lock) {
		this.reminder = reminder;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (start <= MAX) {
				while (start % 2 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(start > MAX) break; // stop extra execution of thread
				System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + start);
				start++;
				lock.notifyAll();
			}
		}
	}
}

public class EvenOddThreadApproach1 {

	public static void main(String[] args) {
		Object o = new Object();
		new Thread(new EvenOddPrintJob(1, o)).start();
		new Thread(new EvenOddPrintJob(0, o)).start();
	}

}
