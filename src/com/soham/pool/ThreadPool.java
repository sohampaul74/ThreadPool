package com.soham.pool;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.soham.custom.threads.PoolThreads;
import com.soham.observer.PoolObserver;
import com.soham.queue.TaskQueue;

public class ThreadPool implements PoolObserver {

	private TaskQueue taskQueue = null;
	private List<PoolThreads> threadList = null;
	private boolean isStopped = false;
	private List<Integer> deadThreadList = null;
	
	public ThreadPool(int maxNumberOfTasks) {
		taskQueue = new TaskQueue(this);
		threadList = new ArrayList<PoolThreads>();
		deadThreadList = new ArrayList<Integer>();
		
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
		System.out.println("new task added");
	}
	
	public synchronized void stopPool() {
		this.isStopped = true;
		for (PoolThreads poolThreads : threadList) {
			poolThreads.stopThread();
		}
	}

	private synchronized PoolThreads getIdleThread() {
		int index = 0;
		deadThreadList.clear();
		for (Iterator<PoolThreads> iterator = threadList.iterator(); iterator.hasNext();) {
			PoolThreads poolThreads = (PoolThreads) iterator.next();
			if (poolThreads.getThreadState() == State.TERMINATED) {
				deadThreadList.add(new Integer(index));
			} else if (poolThreads.getThreadState() == State.NEW) {
				break;
			} 
			index++;
		}
		updateThread();
		return threadList.get(index);
	}
	
	public synchronized void threadRequired() {
		PoolThreads pt = getIdleThread();
		pt.start();
	}
	
	private void updateThread() {
		//System.out.println("new thread updated at: "+index);
		
		for (Iterator<Integer> iterator = deadThreadList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			PoolThreads pt = new PoolThreads(taskQueue);
			threadList.remove(integer);
			threadList.add(pt);
		}
	}
}
