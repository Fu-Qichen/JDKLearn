package org.epr.multitask;

public class TestYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---run");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"---stop");
    }

    public static void main(String[] args) {
        Runnable method=new TestYield();
        new Thread(method,"Evening").start();
        new Thread(method,"PrimeRose").start();
    }
}
