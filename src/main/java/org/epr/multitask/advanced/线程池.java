package org.epr.multitask.advanced;

import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) {
        //创建服务
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new RunnableImpl());
        service.submit(new RunnableImpl());
//        service.submit(new CallableImpl());

        //关闭服务
        service.shutdown();
    }
}


class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
class CallableImpl implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}