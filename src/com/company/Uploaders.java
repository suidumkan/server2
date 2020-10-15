package com.company;

public class Uploaders extends Thread {
    public void run() {
        super.run();
        try {
            System.out.println("Начинается загрузка файла.....  ");
            sleep(1000);
            for (int i = 0; i < 10 ; i++) {
                System.out.print("\uD83D\uDE80");
                sleep(500);

            }
            System.out.println("Файл успешно загрузился на сервер ");
            sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
