package org.epr.multitask.advanced.生产者消费者;

/**
 * 管程法：利用缓冲区
 */
public class 管程法 {

    public static void main(String[] args) {
        SyncManager contain=new SyncManager();
        Producer p = new Producer(contain);
        Consumer c = new Consumer(contain);


        new Thread(p).start();
        new Thread(c).start();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {

    SyncManager contain;
    public Producer(SyncManager contain) {
        this.contain = contain;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            contain.push(new Product(i));
            System.out.println(Thread.currentThread().getName()+"生产产品"+i);
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    SyncManager contain;

    public Consumer(SyncManager contain) {
        this.contain = contain;
    }
    @Override
    public void run() {
                for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"消费产品"+contain.pop().id);
        }
    }
}

/**
 * 产品
 */
class Product{
    int id;
    Product(int id){
        this.id = id;
    }
}

/**
 * 缓冲区
 */
class SyncManager{
    Product[] products=new Product[10];

    int count=0;

    public synchronized void push(Product product) {
        if(products.length==count){
            //等待消费者消费
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        products[count]=product;
        count++;
        //通知消费者消费
        this.notifyAll();
    }

    public synchronized Product pop(){
        if(count==0){
            //等待生产者生产
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count--;
        Product product = products[count];

        //通知生产者生产
        this.notifyAll();

        return product;
    }

}