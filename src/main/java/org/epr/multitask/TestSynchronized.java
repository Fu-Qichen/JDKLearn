package org.epr.multitask;

import java.util.ArrayList;
import java.util.List;

public class TestSynchronized {


    public static void main(String[] args) throws InterruptedException {
        List<String> threads = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (threads) {
                    threads.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(threads.size());
    }
}
