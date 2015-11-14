package com.soham.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.soham.observer.PoolObserver;

public class TaskQueue {
	private Queue<Runnable> queue = null;
	private PoolObserver poolObserver = null;
	
	public TaskQueue(PoolObserver poolObserver) {
		queue = new LinkedList<>();
		this.poolObserver = poolObserver;
	}
	
	/**
	 * inserts runnable tasks inside queue
	 * @param task
	 */
	public void enqueue(Runnable task) {
		queue.add(task);
		//System.out.println(queue.size());
		poolObserver.threadRequired();
	}
	
	/**
	 * returns queue elements and removes it from the queue
	 * @return
	 */
	public synchronized Runnable dequeue() {
		return queue.poll();
	}
	
	public int currentQueueSize() {
		return queue.size();
	}
}
