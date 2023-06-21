package org.epr.multitask;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程操作同一个对象
 */
public class TestThread4 implements Runnable {
    private static int ticks = 5;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        TestThread4 method = new TestThread4();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(method, "乘客" + i));
        }
        for (Thread t : threads) {
            t.start();
        }

    }

    @Override
    public void run() {
        while (true) {
            if (ticks <= 0)
                break;

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "买票成功,还有" + --ticks);
        }
    }
}
