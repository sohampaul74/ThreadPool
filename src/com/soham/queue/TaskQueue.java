package com.soham.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.soham.custom.observer.QueueObserver;
import com.soham.pool.ThreadPool;

public class TaskQueue {
	private Queue<Runnable> queue = null;
	
	public TaskQueue() {
		queue = new LinkedList<>();
	}
	
	/**
	 * inserts runnable tasks inside queue
	 * @param task
	 */
	public synchronized void enqueue(Runnable task) {
		queue.add(task);
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
