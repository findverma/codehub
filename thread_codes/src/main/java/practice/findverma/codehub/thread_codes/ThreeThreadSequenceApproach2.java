package practice.findverma.codehub.thread_codes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreeThreadPrintJob2 implements Runnable {
	private final Lock lock;
	private final Condition condition;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public ThreeThreadPrintJob2(int reminder, Lock lock, Condition condition) {
		this.reminder = reminder;
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		
		lock.lock();
		while (start < MAX-1) { // 2 less iteration required
			while (start % 3 != reminder) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + start);
			start++;
			condition.signalAll();
		}
		lock.unlock();
	}
}
public class ThreeThreadSequenceApproach2 {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition cond = lock.newCondition();
		/*new Thread(new ThreeThreadPrintJob2(1, lock, cond)).start();
		new Thread(new ThreeThreadPrintJob2(2, lock, cond)).start();
		new Thread(new ThreeThreadPrintJob2(0, lock, cond)).start();*/
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new ThreeThreadPrintJob2(1, lock, cond));
		service.execute(new ThreeThreadPrintJob2(2, lock, cond));
		service.execute(new ThreeThreadPrintJob2(0, lock, cond));
		service.shutdown();
	}

}
