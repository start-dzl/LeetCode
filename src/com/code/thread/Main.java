package com.code.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		var q = new TaskQueue();
		var ts = new ArrayList<Thread>();
		for (int i=0; i<5; i++) {
			var t = new Thread() {
				public void run() {
					// 执行task:
					while (true) {
						try {
							String s = q.getTask();
							System.out.println("execute task: " + s);
						} catch (InterruptedException e) {
							return;
						}
					}
				}
			};
			t.start();
			ts.add(t);
		}
		var add = new Thread(() -> {
			for (int i=0; i<10; i++) {
				// 放入task:
				String s = "t-" + Math.random();
				System.out.println("add task: " + s);
				q.addTask(s);
				try { Thread.sleep(100); } catch(InterruptedException e) {}
			}
		});
		add.start();
		add.join();
		Thread.sleep(100);
		for (var t : ts) {
			t.interrupt();
		}
	}
}


