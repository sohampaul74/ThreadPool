package com.soham.unit.test;

import com.soham.pool.ThreadPool;

public class UnitTestCase {
	public static void main(String[] args) {
		ThreadPool tp = new ThreadPool(10);
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo1");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo2");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo3");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo4");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo5");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo6");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo7");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo8");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo9");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo11");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo12");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo13");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo14");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo15");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo16");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo17");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo18");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo19");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo21");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo22");
			}
		});
		tp.addTask(new Runnable() {
			public void run() {
				System.out.println("gtfo gtfo23");
			}
		});
	}
}
