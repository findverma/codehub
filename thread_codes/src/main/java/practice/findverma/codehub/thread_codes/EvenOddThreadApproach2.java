package practice.findverma.codehub.thread_codes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EvenOddPrintJob2 implements Runnable {
	private final Lock lock;
	private final Condition condition;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public EvenOddPrintJob2(int reminder, Lock lock, Condition conditon) {
		this.reminder = reminder;
		this.lock = lock;
		this.condition = conditon;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			while (start <= MAX) {
				while (start % 2 != reminder) {
					condition.await();
				}
				if(start > MAX) break; // stop extra execution of thread
				System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + start);
				start++;
				condition.signalAll();
			}
		
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}

public class EvenOddThreadApproach2 {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condtion = lock.newCondition();
		//new Thread(new EvenOddPrintJob2(1, lock, condtion)).start();
		//new Thread(new EvenOddPrintJob2(0, lock, condtion)).start();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new EvenOddPrintJob2(1, lock, condtion));
		service.execute(new EvenOddPrintJob2(0, lock, condtion));
		service.shutdown();
	}

}
