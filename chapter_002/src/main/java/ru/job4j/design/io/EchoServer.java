package ru.job4j.design.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    boolean rsl = false;
                    String bye = "bye";
                    String str = in.readLine();
                    String[] strings = str.replaceAll("=", " ").split(" ");
                    for (String string : strings) {
                        if (string.toLowerCase().equals(bye)) {
                            rsl = true;
                        }
                    }
                    if (rsl) {
                        socket.close();
                        System.out.println("Сокет закрыт");
                    } else if (!str.isEmpty()) {
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        }
    }
}
