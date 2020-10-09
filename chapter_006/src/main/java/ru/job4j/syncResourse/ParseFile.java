package ru.job4j.syncResourse;

import java.io.*;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public String getContent() throws IOException {

        StringBuilder output = new StringBuilder();
        try(InputStream i = new FileInputStream(file);) {
            for (int data = -100500; data != -1; data = i.read()) {
                output.append((char) data);
            }
        }
        return output.toString();
    }

    public String getContentWithoutUnicode() throws IOException {
        StringBuilder output = new StringBuilder();
        try (InputStream i = new FileInputStream(file)){
            for (int data = -100500; data != -1; data = i.read()) {
                if (data < 0x80) {
                    output.append((char) data);
                }
            }
        }
        return output.toString();
    }

    public void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file);){
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        }
    }
}