package ru.job4j.design.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleChat {
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String END = "закончить";
    private Map<Integer, String> textMap = new HashMap<>();
    private File logChat;
    private File textUser;
    private int count = 1;
    /*
        param textUser - file with answers
        param logChat - file with log after dialog
     */
    public ConsoleChat(File textUser) {
        this.logChat = new File("./logChat.txt");
        this.textUser = textUser;
    }
    /*
       Reading file with answers
     */
    public void readFiles() {
        String text;
        try (BufferedReader in = new BufferedReader(new FileReader(textUser))) {
            while ((text = in.readLine()) != null) {
                textMap.put(count, text);
                count++;
                in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
        Write file after dialog
     */
    public void writeFiles(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logChat, true))) {
            writer.write(log + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    this method reads user questions
    the bot responds randomly with lines from the file
     */
    public void consoleDialog() {
        boolean stopCount = false;
        String words, text;
        String wordLowerCase = "";
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Привет, я Алиса, давай общаться");
            while (!wordLowerCase.equals(END)) {
                words = in.nextLine();
                wordLowerCase = words.toLowerCase();
                writeFiles(words);
                if ((!wordLowerCase.equals(STOP)) && !stopCount
                        && wordLowerCase.length() > 0
                        && (!wordLowerCase.equals(END))) {
                    text = textMap.get((int) ((Math.random() * (count - 1) + 1)));
                    System.out.println(text);
                    writeFiles(text);
                } else if (wordLowerCase.equals(CONTINUE)) {
                    System.out.println("Продолжаем разговор");
                    stopCount = false;
                }
                if (wordLowerCase.equals(STOP)) {
                    stopCount = true;
                }
            } if (wordLowerCase.equals(END)) {
                System.out.println("До скорых волнительных встреч");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat(new File("./Ответы.txt"));
            chat.readFiles();
            chat.consoleDialog();
    }
}
