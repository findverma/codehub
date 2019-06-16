package practice.findverma.codehub.thread_codes;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
// Producer Consumer design is implemented by wait and notify. 
// you can also replace wait and notify with Lock API with Condition.
// You can also implement with the help of two Semaphore(1) and Semaphore(0).
class ProducerApproach1 implements Runnable {
	LinkedList<String> sharedList;
	private final int MAX;
	private volatile int putIndex = 0;

	public ProducerApproach1(LinkedList<String> list, int max) {
		this.sharedList = list;
		this.MAX = max;
	}

	@Override
	public void run() {
		IntStream.range(0, 20).forEach(e -> {
			put(Integer.toString(e));
		});
	}

	private void put(String data) {
		try {
			synchronized (sharedList) {
				while (MAX == sharedList.size()) {
					sharedList.wait();
				}
				System.out.println("Producing : "+ data);
				sharedList.add(data);
				putIndex++;
				if (putIndex == sharedList.size())
					putIndex = 0;

				sharedList.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ConsumerApproach1 implements Runnable{

	LinkedList<String> sharedList;
	private final int MAX;
	private volatile int takeIndex = 0;

	public ConsumerApproach1(LinkedList<String> list, int max) {
		this.sharedList = list;
		this.MAX = max;
	}

	@Override
	public void run() {
		IntStream.range(0, 20).forEach(e -> {
			System.out.println(take());
		});
	}

	private String take() {
		String data = null;
		try {
			synchronized (sharedList) {
				while (sharedList.isEmpty()) {
					sharedList.wait();
				}
				data = sharedList.remove();
				System.out.println("Consuming : "+ data);
				takeIndex++;
				if (takeIndex == sharedList.size())
					takeIndex = 0;

				sharedList.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return data;
	}


}

public class ProducerConsumerApproach1 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new ProducerApproach1(list, 20));
		service.execute(new ConsumerApproach1(list, 20));
		service.shutdown();

	}

}
