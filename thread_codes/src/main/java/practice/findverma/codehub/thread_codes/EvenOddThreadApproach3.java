package practice.findverma.codehub.thread_codes;

import java.util.concurrent.Semaphore;

class EvenOddPrintJob3 implements Runnable {
	private final Semaphore semaphore;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public EvenOddPrintJob3(int reminder, Semaphore semaphore) {
		this.reminder = reminder;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			while (start < MAX) {  // One less iteration
				while (start % 2 != reminder) {
					semaphore.release();
				}
				System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + start);
				start++;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class EvenOddThreadApproach3 {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		new Thread(new EvenOddPrintJob3(1, semaphore)).start();
		new Thread(new EvenOddPrintJob3(0, semaphore)).start();

	}

}
