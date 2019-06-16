package practice.findverma.codehub.thread_codes;

public class ThreadDeadLock {

	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		
		// This thread attempts to acquired lock on O1 then O2
		new Thread(()->{
			System.out.println("Acquiring Lock on O1 by "+Thread.currentThread().getName());
			synchronized (o1) {
				System.out.println("Acquiring Lock on O2 by "+Thread.currentThread().getName());
				synchronized (o2) {
					System.out.println("Lock acquired on O1 and O2");
				}
			}
		}).start();
		
		//This thread attempts to acquired lock on O2 then O1
		new Thread(()->{
			System.out.println("Acquiring Lock on O2 by "+Thread.currentThread().getName());
			synchronized (o2) {
				System.out.println("Acquiring Lock on O1 by "+Thread.currentThread().getName());
				synchronized (o1) {
					System.out.println("Lock acquired on O1 and O2");
				}
			}
		}).start();
	}

}
