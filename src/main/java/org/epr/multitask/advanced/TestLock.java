package org.epr.multitask.advanced;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 * ReentrantLock是Lock的实现
 */
public class TestLock {


    public static void main(String[] args) {
        BuyTicker method = new BuyTicker();

        new Thread(method).start();
        new Thread(method).start();
        new Thread(method).start();
    }
}


class BuyTicker implements Runnable {

    private final ReentrantLock lock = new ReentrantLock();
    int MAX = 10;
    int tickerIndex = 0;

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                if (tickerIndex >= MAX)
                    break;
                else {
                    Thread.sleep(200);
                    System.out.println("乘客" + Thread.currentThread().getName() + "买了第" + tickerIndex++ + "票");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

    }
}