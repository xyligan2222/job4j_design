package ru.job4j.design.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.StringJoiner;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("unavailable.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01 " + System.lineSeparator()
            + "500 10:57:01 " + System.lineSeparator()
            + "400 10:58:01 " + System.lineSeparator()
            + "200 10:59:01 " + System.lineSeparator()
            + "500 11:01:02 " + System.lineSeparator()
            + "200 11:02:02 ");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner rsl = new StringJoiner(System.lineSeparator());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::add);
        }
        String expected = ("10:57:01 10:59:01"  + System.lineSeparator()
                + "11:01:02 11:02:02");
        assertThat(rsl.toString(), is(expected));
    }
}
