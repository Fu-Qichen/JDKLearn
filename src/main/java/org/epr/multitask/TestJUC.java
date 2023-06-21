package org.epr.multitask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * JUC安全类型集合java.util.concurrent
 */
public class TestJUC {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> threads =new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                threads.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(threads.size());
    }
}
