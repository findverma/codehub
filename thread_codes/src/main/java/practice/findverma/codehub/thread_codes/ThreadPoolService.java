package practice.findverma.codehub.thread_codes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public interface ThreadPoolService {
	public void execute(Runnable task) throws InterruptedException;
	public void shutDown();
}

final class ThreadPoolServiceImpl implements ThreadPoolService {

	private BlockingQueue<Runnable> taskQueue;
	private List<Thread> pools;
	private AtomicBoolean isShutdownInitiated;

	private ThreadPoolServiceImpl() {
	}

	public static ThreadPoolService newThreadPool(int limit) {
		ThreadPoolServiceImpl pool = new ThreadPoolServiceImpl();
		pool.taskQueue = new LinkedBlockingQueue<>();
		pool.pools = new ArrayList<>(limit);
		startPool(pool, limit);
		pool.isShutdownInitiated = new AtomicBoolean();
		return pool;
	}
	
	private static void startPool(ThreadPoolServiceImpl pool, int limit){
		for(int i=0; i<limit; i++){
			pool.pools.add(new Thread(){
				@Override
				public void run() {
					while (!pool.isShutdownInitiated.get()) {
						Runnable r;
						while ((r = pool.taskQueue.poll()) != null) {
							r.run();
						}
					}
				}
			});
			
		}
	}

	@Override
	public void execute(Runnable task) throws InterruptedException {
		if(this.isShutdownInitiated.get() == true){
			throw new IllegalMonitorStateException();
		}
		this.taskQueue.put(task);
	}

	@Override
	public void shutDown() {
		isShutdownInitiated= new AtomicBoolean(true);
	}

}




