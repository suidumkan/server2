package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Uploaders uploaders = new Uploaders();
        uploaders.start();
        uploaders.join();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10 ; i++) {
            Downloaders downloaders = new Downloaders(semaphore, countDownLatch, i);
            downloaders.start();
        }
        countDownLatch.await();
        System.err.println("Файл удален с сервера ");

    }
}
