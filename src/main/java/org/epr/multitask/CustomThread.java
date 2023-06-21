package org.epr.multitask;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomThread extends Thread {

    private final String url;
    private final String fileName;

    public CustomThread(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new CustomThread("https://pic3.zhimg.com/v2-ab5c6c7643d5bedeece7fccb5d7ec2a1_r.jpg", i + ".jpg");
            threads.add(thread);

        }
        for (int i = 0; i < 3; i++) {
            threads.get(i).start();
        }
    }

    @Override
    public void run() {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + ":" + fileName);
    }
}