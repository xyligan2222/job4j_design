package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String[] strings = new String[] {"|", "/", "--", "\\", "|", "/", "--", "\\"};
        int index = 0;
        while (!Thread.currentThread().isInterrupted()) {
            if ((index) < strings.length) {
                System.out.print("\rLoading : "  + strings[index]);
                index++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                index = 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
    }
}
