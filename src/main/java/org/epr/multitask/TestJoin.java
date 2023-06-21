package org.epr.multitask;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
        System.out.println(Thread.currentThread().getName()+" is running---"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Runnable method=new TestJoin();
        Thread t=new Thread(method,"Evening");
        t.start();

        for (int i = 0; i < 1000; i++) {
            if(i==200)
                t.join();//使其他线程（主线程)阻塞
            System.out.println("main is running---"+i);
        }

    }
}
