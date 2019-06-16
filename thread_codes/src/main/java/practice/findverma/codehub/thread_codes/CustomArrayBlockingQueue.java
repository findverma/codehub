package practice.findverma.codehub.thread_codes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface MyBlockingQueue{
	public void put(Object data) throws InterruptedException;
	public Object take() throws InterruptedException;
}

class MyQueueArrayBasedImpl implements MyBlockingQueue{
	
	private final Object[] arrayQueue;
	private final Lock lock = new ReentrantLock();
	private final Condition producerCond = lock.newCondition();
	private final Condition consumerCond=lock.newCondition();
	private volatile int size=0;
	private volatile int putIndex, takeIndex;
	
	public MyQueueArrayBasedImpl() {
		arrayQueue = new Object[10];
	}
	
	@Override
	public synchronized void put(Object data) throws InterruptedException {
		lock.lock();
		try{
			while(size == arrayQueue.length)
				producerCond.await();
			
			arrayQueue[putIndex] = data;
			putIndex++;
			if (putIndex == arrayQueue.length){
				putIndex = 0;
			}
			++size;
			consumerCond.signal();
		}finally {
			lock.unlock();
		}
	}

	@Override
	public synchronized Object take() throws InterruptedException {
		Object data = null;
		lock.lock();
		try{
			while(size == 0)
				consumerCond.await();
			
			data = arrayQueue[takeIndex];
			takeIndex++;
			if (takeIndex == arrayQueue.length){
				takeIndex = 0;
			}
			--size;
			producerCond.signal();
		}finally {
			lock.unlock();
		}
		return data;
	}
	
} 
public class CustomArrayBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
