package ru.job4j.design.io;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class ResultFileTest {
    @Test
    public void whenWriteToFile() {
        ResultFile.multiplicationTable(10);
        ResultFile.writeToFile(10);
    }

}
