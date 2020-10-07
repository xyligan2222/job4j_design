package ru.job4j.common;

public final class DCLSingleton {
    private static  volatile DCLSingleton inst;

    public static synchronized DCLSingleton instOf() {
        if (inst == null) {
                if (inst == null) {
                    inst = new DCLSingleton();
                }

        }
        return inst;
    }


    private DCLSingleton() {
    }
}