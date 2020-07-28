package ru.job4j.design.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG =  LoggerFactory.getLogger(UsageLog4j.class.getName());
    
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean rslBye = false;
            while (!rslBye) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    boolean rslHello = false;
                    String bye = "exit";
                    String hello = "hello";
                    String str = in.readLine();
                   String[] strings = str.replaceAll("=", " ").split(" ");
                    for (String string : strings) {
                        if (string.toLowerCase().equals(bye)) {
                            rslBye = true;
                            break;
                        }
                        if (string.toLowerCase().equals(hello)) {
                            rslHello = true;
                        }
                    }
                    if (rslBye) {
                        socket.close();
                        System.out.println("Сокет закрыт");
                    } else if (rslHello) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(("Hello" + "\n").getBytes());
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(((strings[2]).replaceAll("%D1%83", "") + "\n").getBytes());
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
