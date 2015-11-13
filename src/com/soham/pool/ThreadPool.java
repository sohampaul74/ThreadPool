package com.soham.pool;

//import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;

import com.soham.custom.threads.PoolThreads;
import com.soham.queue.TaskQueue;

public class ThreadPool {

	private TaskQueue taskQueue = null;
//	private boolean isExecutable = true;
	private List<PoolThreads> threadList = null;
	private boolean isStopped = false;
	
	public ThreadPool(int maxNumberOfTasks) {
		taskQueue = new TaskQueue();
		threadList = new ArrayList<PoolThreads>();
		
		for(int i=0; i<maxNumberOfTasks; i++) {
			PoolThreads poolThreads = new PoolThreads(taskQueue);
			threadList.add(poolThreads);
		}
		
	}
	
	public synchronized void addTask(Runnable task) {
		if (this.isStopped) {
			throw new IllegalStateException("Thread pool was stopped!");
		}
		this.taskQueue.enqueue(task);
	}
	
	public synchronized void stopPool() {
		this.isStopped = true;
		for (PoolThreads poolThreads : threadList) {
			poolThreads.stopThread();
		}
	}
	
//	private synchronized int checkPoolStatus() {
//		int i=0;
//		for (PoolThreads poolThreads : threadList) {
//			if (poolThreads.getState() == State.NEW) {
//				break;
//			}
//			i++;
//		}
//		return i;
//	}
//	
//	private synchronized void startExecution(int index) {
//		
//	}
	
}
