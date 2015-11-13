package com.soham.custom.threads;

import com.soham.queue.TaskQueue;

public class PoolThreads extends Thread {

	private TaskQueue taskQueue = null;
	private Boolean isStopped = false;
	
	public PoolThreads(TaskQueue taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while(!isStopped) {
			try {
				if (taskQueue.currentQueueSize() > 0) {
					Runnable runnable = taskQueue.dequeue();
					runnable.run();
				}
			} catch(Exception ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public synchronized void stopThread() {
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
	
}
