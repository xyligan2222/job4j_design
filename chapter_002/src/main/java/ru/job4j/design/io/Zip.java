package ru.job4j.design.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
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
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_002/pom.xml"),
                new File("./chapter_002/pom.zip")
        );

        ArgZip argZip = new ArgZip(new String[]{"java -jar pack.jar -d=C:\\projects\\job4j_design\\chapter_002 -e=xml -o=project.zip"});
        Search search = new Search();
        argZip.setKey();
        List<Path> paths = search.search(Paths.get(argZip.getKey("d")), argZip.getKey("e"));

        new Zip().packFiles(paths, new File(argZip.getKey("o")));
    }
}
