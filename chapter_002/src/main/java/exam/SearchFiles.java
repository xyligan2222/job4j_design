package exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.design.io.PrintFiles;
import ru.job4j.design.io.UsageLog4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SearchFiles {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        Keys keys = new Keys();
        keys.keys(args);
        ArrayList<String> list = new ArrayList<>();
        System.out.println(keys.output());
        System.out.println(keys.directory());
        System.out.println(keys.fileName());
        System.out.println(keys.valid());
        System.out.println(keys.maxMatch());
        if (keys.valid()) {
            Path root = Paths.get(keys.directory());

        }
    }

     /*
        method search  find file
    */

    public static List<Path> search(Path root, String ext) throws IOException {
        PrintFiles searcher = new PrintFiles(p -> p.getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getList();
    }
    /*
       method writeToLog  writer log to File from program directory
   */
    public static void writeToLog(ArrayList<String> list)  {
        Keys keys = new Keys();
        File log = new File(keys.fileName());
        try (BufferedWriter resultBuffer = new BufferedWriter(new FileWriter(log, true))) {
            for (String lists : list) {
                if (!lists.isEmpty()) {
                    resultBuffer.write(lists + System.lineSeparator());
                }

            }
        } catch (IOException e) {
           LOG.error("Write to log" + e);
        }
    }

    public static void resultSourceFiles(List<Path> sourceFiles, ArrayList<String> output) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (Path file: sourceFiles) {
            sj.add(file.toFile().getAbsolutePath());
        }
        writeToLog(output);
    }

    public void packFiles(List<Path> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<Path> iterator = sources.iterator();
            while (iterator.hasNext()) {
                zip.putNextEntry(new ZipEntry(iterator.next().toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(iterator.next().toFile()))) {
                    zip.write(out.readAllBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
