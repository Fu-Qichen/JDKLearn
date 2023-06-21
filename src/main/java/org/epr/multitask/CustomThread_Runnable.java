package org.epr.multitask;

import java.util.ArrayList;
import java.util.List;

public class CustomThread_Runnable implements Runnable {

    private final String name;

    public CustomThread_Runnable(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//            Thread thread=new CustomThread("https://pic3.zhimg.com/v2-ab5c6c7643d5bedeece7fccb5d7ec2a1_r.jpg",i+".jpg");
            threads.add(new Thread(new CustomThread_Runnable(String.valueOf(i))));
        }
        for (int i = 0; i < 3; i++) {
            threads.get(i).start();
        }
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("CustomThread_Runnable" + name + ":" + i);
        }
    }
}