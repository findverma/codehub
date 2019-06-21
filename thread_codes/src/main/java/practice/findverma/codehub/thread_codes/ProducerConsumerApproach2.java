package practice.findverma.codehub.thread_codes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

// Blocking Queue is producer consumer design pattern for shared collection.
// you don't need to maintain thread safety by your own.
class ProducerApproach2 implements Runnable {
	
	BlockingQueue<String> sharedQueue;

	public ProducerApproach2(BlockingQueue<String> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		IntStream.range(0, 20).forEach(e -> {
			put(Integer.toString(e));
		});
	}

	private void put(String data) {
		try {
			sharedQueue.put(data);
			System.out.println("Producing : "+ data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ConsumerApproach2 implements Runnable {
	
	BlockingQueue<String> sharedQueue;

	public ConsumerApproach2(BlockingQueue<String> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		IntStream.range(0, 20).forEach(e -> {
			System.out.println("Consuming : "+ take());
		});
	}

	private String take() {
		String data = null;
		try {
			data = sharedQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return data;
	}

}

public class ProducerConsumerApproach2 {

	public static void main(String[] args) {

		BlockingQueue<String> list = new LinkedBlockingQueue<>();
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new ProducerApproach2(list));
		service.execute(new ConsumerApproach2(list));
		service.shutdown();

	
	}

}
