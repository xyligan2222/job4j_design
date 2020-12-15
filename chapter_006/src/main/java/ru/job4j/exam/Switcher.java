package ru.job4j.exam;

public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier masterSlaveBarrier = new MasterSlaveBarrier();
    Thread first = new Thread(
            () -> {
                while (true) {
                    Thread.currentThread().setName("Thread A");
                    masterSlaveBarrier.tryMaster();
                    masterSlaveBarrier.doneMaster();
                }
            }
    );
    Thread second = new Thread(
            () -> {
                while (true) {
                    Thread.currentThread().setName("Thread B");
                    masterSlaveBarrier.trySlave();
                    masterSlaveBarrier.doneSlave();
                }
            }
    );
        first.start();
        second.start();

}
}


