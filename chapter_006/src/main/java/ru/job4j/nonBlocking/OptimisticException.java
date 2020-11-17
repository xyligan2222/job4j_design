package ru.job4j.nonBlocking;

public class OptimisticException extends RuntimeException {
    public OptimisticException(String msg){
        super(msg);
    }
}
