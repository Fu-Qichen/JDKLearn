package org.epr.multitask;

import java.util.concurrent.*;

/**
 * 创建执行服务
 * 提交执行
 * 获取结果
 * 关闭服务
 * 与Runnable区别：返回值+抛出异常
 */
public class CustomThread_Callable implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CustomThread_Callable tc1 = new CustomThread_Callable();
        CustomThread_Callable tc2 = new CustomThread_Callable();
        CustomThread_Callable tc3 = new CustomThread_Callable();

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<String> r1 = es.submit(tc1);
        Future<String> r2 = es.submit(tc2);
        Future<String> r3 = es.submit(tc3);

        String rs1 = r1.get();
        String rs2 = r2.get();
        String rs3 = r3.get();

        es.shutdown();
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }
}