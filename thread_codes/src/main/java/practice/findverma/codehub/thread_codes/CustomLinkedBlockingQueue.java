package practice.findverma.codehub.thread_codes;

import java.util.LinkedList;

class MyQueueLinkListBasedImpl implements MyBlockingQueue{

	private final LinkedList<Object> linkedQueue = new LinkedList<>();
	@Override
	public synchronized void put(Object data) throws InterruptedException {
		linkedQueue.add(data);
		notifyAll();
	}

	@Override
	public synchronized Object take() throws InterruptedException {
		while (linkedQueue.isEmpty()) {
			wait();
		}
		return linkedQueue.remove();
	} 
	
}

public class CustomLinkedBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
