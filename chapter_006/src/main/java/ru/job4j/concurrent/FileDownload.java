package ru.job4j.concurrent;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class FileDownload implements Runnable {
    private static final int KB = 1024;

    @Override
    public void run() {
        String file = "https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml";
        Double kbSec = 1.0;
        URL url = null;
        try {
            url = new URL(file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();
        try (BufferedInputStream in = new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[(int) (kbSec * KB)];
            int bytesRead;
            do {
                //long startTime = System.currentTimeMillis();
                bytesRead = in.read(dataBuffer, 0, (int) (kbSec * KB ));
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                long endTime = System.currentTimeMillis();
                long difference = (endTime - startTime);
                System.out.println("Time: " + difference);
                if (bytesRead > kbSec * KB) {
                    Thread.sleep(difference - bytesRead);
                }
            } while (bytesRead != -1);

        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new FileDownload());
        thread.start();

    }

}

