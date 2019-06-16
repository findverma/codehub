package practice.findverma.codehub.thread_codes;

class ThreeThreadPrintJob implements Runnable {
	private final Object lock;
	private final int MAX = 10;
	private final int reminder;
	private static volatile int start = 1;

	public ThreeThreadPrintJob(int reminder, Object lock) {
		this.reminder = reminder;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (start < MAX-1) {  // 2 less iteration required
				while (start % 3 != reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Thread Name: " + Thread.currentThread().getName() + " : " + start);
				start++;
				lock.notifyAll();
			}
		}
	}
}
public class ThreeThreadSequenceApproach1 {

	public static void main(String[] args) {
		Object o = new Object();
		new Thread(new ThreeThreadPrintJob(1, o)).start();
		new Thread(new ThreeThreadPrintJob(2, o)).start();
		new Thread(new ThreeThreadPrintJob(0, o)).start();
	}

}
