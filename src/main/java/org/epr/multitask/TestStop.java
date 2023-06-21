package org.epr.multitask;

public class TestStop implements Runnable {

    boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        TestStop method=new TestStop();
        Thread t = new Thread(method);

        t.start();

        Thread.sleep(200);
        method.stop();
        System.out.println("线程stop");

    }

    @Override
    public void run() {
        int i=0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() +"-----"+ i++);
        }
    }

    public void stop() {
        this.flag = false;
    }
}
