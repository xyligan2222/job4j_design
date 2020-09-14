package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ProgrammerReport implements Report {
    private Store store;

    public ProgrammerReport(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
