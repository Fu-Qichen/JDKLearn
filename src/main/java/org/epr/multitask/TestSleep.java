package org.epr.multitask;

import java.time.LocalDateTime;

public class TestSleep implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(LocalDateTime.now());
        }
    }

    public static void main(String[] args) {
        Runnable method=new TestSleep();
        Thread t=new Thread(method);

        t.start();
    }
}
