package practice.findverma.codehub.thread_codes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class ThreeThreadPrintJob3 implements Runnable {
	private final Semaphore semaphore;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public ThreeThreadPrintJob3(int reminder, Semaphore semaphore) {
		this.reminder = reminder;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			while (start < MAX-1) { // 2 less iteration required
				while (start % 3 != reminder) {
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
public class ThreeThreadSequenceApproach3 {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		/*new Thread(new ThreeThreadPrintJob3(1, semaphore)).start();
		new Thread(new ThreeThreadPrintJob3(2, semaphore)).start();
		new Thread(new ThreeThreadPrintJob3(0, semaphore)).start();*/
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new ThreeThreadPrintJob3(1, semaphore));
		service.execute(new ThreeThreadPrintJob3(2, semaphore));
		service.execute(new ThreeThreadPrintJob3(0, semaphore));
		service.shutdown();
	}

}
