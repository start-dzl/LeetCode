package com.code.thread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class MainFeature {
	public static void main(String[] args) throws Exception {
		// 第一个任务:
		CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
			return queryCode("中国石油");
		});
		// cfQuery成功后继续执行下一个任务:
		CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
			return fetchPrice(code);
		});
		// cfFetch成功后打印结果:
		cfFetch.thenAccept((result) -> {
			System.out.println("price: " + result);
		});
		// 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
		Thread.sleep(2000);
	}

	static String queryCode(String name) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		return "601857";
	}

	static Double fetchPrice(String code) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		return 5 + Math.random() * 20;
	}
}

class TaskMF implements Callable<BigDecimal> {

	public TaskMF(String code) {
	}

	@Override
	public BigDecimal call() throws Exception {
		Thread.sleep(1000);
		double d = 5 + Math.random() * 20;
		return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
	}
}
