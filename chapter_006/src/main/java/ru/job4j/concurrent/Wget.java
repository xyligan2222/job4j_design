package ru.job4j.concurrent;

public class Wget {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    for (int i = 0; i < 100 ; i++) {
                        System.out.print("\rLoading : " + i + "%");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                            Thread.currentThread().interrupt();
                            System.out.println();
                            System.out.println(Thread.currentThread().isInterrupted());
                            System.out.println(Thread.currentThread().getState());
                        }
                    }
                }
        );
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }
}
