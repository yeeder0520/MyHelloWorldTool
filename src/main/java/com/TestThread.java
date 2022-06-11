package com;

import java.util.concurrent.Semaphore;

public class TestThread implements Runnable{
	private String threadName;
	private Semaphore semaphore;

	public TestThread(String threadName, Semaphore semaphore) {
		this.threadName = threadName;
		this.semaphore = semaphore;
	}
	@Override
	public void run() {
		try {
			this.semaphore.acquire();
			System.out.println("GOGO : " + this.threadName);
			Thread.sleep(6000L);
			this.semaphore.release();
			System.out.println("END" + this.threadName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
