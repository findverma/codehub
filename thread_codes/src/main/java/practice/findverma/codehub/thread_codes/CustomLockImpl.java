package practice.findverma.codehub.thread_codes;

interface CustomeLock {
	public void lock() throws InterruptedException;
	public void unLock();
	public boolean tryLock() throws InterruptedException;
}

public class CustomLockImpl implements CustomeLock {

	private int lockCount = 0;
	private boolean isLocked = false;
	private Thread lockedByThread = null;

	@Override
	public synchronized void lock() throws InterruptedException {
		// current thread keep waiting if lock is acquired by another thread
		while (isLocked == true && Thread.currentThread() != lockedByThread) {
			this.wait();
		}
		isLocked = true;
		lockedByThread = Thread.currentThread();
		lockCount++;
	}

	@Override
	public synchronized void unLock() {
		// If unLock() is called without lock() then throws Exception
		if (isLocked == false) {
			throw new IllegalMonitorStateException();
		}
		if (lockedByThread == Thread.currentThread()) {
			lockCount--;
			if (lockCount == 0) {
				isLocked = false;
				this.notify();
			}
		}
	}

	@Override
	public synchronized boolean tryLock() throws InterruptedException {
		if (lockCount == 0) {
			lock();
			return true;
		}
		return false;
	}
}

