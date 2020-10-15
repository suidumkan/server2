package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    Semaphore sm;
    CountDownLatch cdl;
    int numUser;

    public Downloaders(Semaphore sm, CountDownLatch cdl, int numUser) {
        this.sm = sm;
        this.cdl = cdl;
        this.numUser = numUser;
    }
    public void run() {
        super.run();
        try {
            sm.acquire();
            System.out.println("User " + numUser + " начинает скачивать файл ");
            sleep(1000);
            System.out.println("User " + numUser + "скачал файл с сервера ");
            cdl.countDown();
            sm.release();
            sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("у User: " + numUser + "нет соединение с сервером ");
        }
    }

}
