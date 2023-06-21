package org.epr.multitask.advanced.生产者消费者;

/**
 * 标志位解决
 */
public class 信号灯法 {
    public static void main(String[] args) {
        产品 产品=new 产品();
        new 生产者(产品).start();
        new 消费者(产品).start();
    }
}

class 生产者 extends Thread{
    产品 产品;
    生产者(产品 产品){
        this.产品=产品;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            产品.生产("产品"+i);
        }
    }
}
class 消费者 extends Thread{
    产品 产品;
    消费者(产品 产品){
        this.产品=产品;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            产品.消费();
        }
    }
}
class 产品{
    //生产者生产，消费者等待
    //消费者消费，生产者等待
    String name;
    boolean flag =true;

    //生产
    public synchronized void 生产(String name){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"生产"+name);

        this.notifyAll();
        this.name=name;
        this.flag=!this.flag;
    }

    //消费
    public synchronized void 消费(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费"+name);

        this.notifyAll();
        this.flag=!this.flag;
    }
}