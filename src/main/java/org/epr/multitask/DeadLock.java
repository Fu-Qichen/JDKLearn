package org.epr.multitask;

/**
 * 死锁
 */
public class DeadLock {


    public static void main(String[] args) {
        Knight k1 = new Knight("John", 1);
        Knight k2 = new Knight("Mike", 2);

        k1.start();
        k2.start();
    }
}


class Sword {

}

class Shield {

}

class Knight extends Thread {
    private static final Sword sword = new Sword();
    private static final Shield shield = new Shield();

    private final String name;

    private final int order;

    Knight(String name, int order) {
        this.name = name;
        this.order = order;
    }

    @Override
    public void run() {
//        if (order == 1) {
//            synchronized (sword) {
//                System.out.println("骑士qishi" + name + "得到🗡");
//                synchronized (shield) {
//                    System.out.println("骑士" + name + "得到🛡");
//                }
//            }
//        } else {
//            synchronized (shield) {
//                System.out.println("骑士" + name + "得到🛡");
//                synchronized (sword) {
//                    System.out.println("骑士" + name + "得到🛡🗡");
//                }
//            }
//        }
        if (order == 1) {
            synchronized (sword) {
                System.out.println("骑士" + name + "得到🗡");
            }
            synchronized (shield) {
                System.out.println("骑士" + name + "得到🛡");
            }
        } else {
            synchronized (shield) {
                System.out.println("骑士" + name + "得到🛡");

            }
            synchronized (sword) {
                System.out.println("骑士" + name + "得到🗡");
            }
        }

    }
}


