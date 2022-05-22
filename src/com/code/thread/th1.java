package com.code.thread;

import java.time.LocalTime;

public class th1 {
    public static void main(String[] args)  throws InterruptedException {
        TimerThread t = new TimerThread();
        t.setDaemon(true);
        t.start();

        Thread.sleep(1);
    }
}

class MyThread extends Thread {
    public void run() {

        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}