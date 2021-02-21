package ru.krisnovitskaya.SimpleWebServer.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    private final static String host = "localhost";
    private final static int port = 8989;
    private final static String newline = "\r\n";





    public static void main(String[] args) throws IOException {
        sendGetRequest1(host, "/simple", port);
        sendPostRequest1(host, "/simple", port, "KRISTINA", "developer");

        sendGetRequest2(host, "/object", port);
        String object = "{\"title\":\"Test name\",\"count\":10}";
        sendPostRequest2(host, "/object", port, object);
    }

    private static void sendGetRequest2(String host, String path, int port) throws IOException {
        try(Socket socket = new Socket(host, port)){
            StringBuilder sb = new StringBuilder();
            sb.append("GET ").append(path).append(" HTTP/1.1").append(newline)
                    .append("Host: ").append(host).append(":").append(port).append(newline)
                    .append("Accept: application/json; utf-8").append(newline)
                    .append("Connection: close").append(newline)
                    .append(newline);

            socket.getOutputStream().write(sb.toString().getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            printResponse(socket.getInputStream());
        }
    }

    private static void sendGetRequest1(String host, String path, int port) throws IOException {
        try(Socket socket = new Socket(host, port)){
            StringBuilder sb = new StringBuilder();
            sb.append("GET ").append(path).append(" HTTP/1.1").append(newline)
                    .append("Host: ").append(host).append(":").append(port).append(newline)
                    .append("Connection: close").append(newline)
                    .append(newline);

            socket.getOutputStream().write(sb.toString().getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            printResponse(socket.getInputStream());
        }
    }

    private static void sendPostRequest1(String host, String path, int port, String name, String position) throws IOException {
        try(Socket socket = new Socket(host, port)){
            String data = "name="+name+"&"+"position="+position;
            StringBuilder sb = new StringBuilder();
            sb.append("POST ").append(path).append(" HTTP/1.1").append(newline)
                    .append("Host: ").append(host).append(":").append(port).append(newline)
                    .append("Connection: close").append(newline)
                    .append("Accept: text/plain;charset=UTF-8").append(newline)
                    .append("Content-Type: application/x-www-form-urlencoded").append(newline)
                    .append("Content-Length: ").append(data.length()).append(newline)
                    .append(newline)
                    .append(data);

            socket.getOutputStream().write(sb.toString().getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            printResponse(socket.getInputStream());

        }
    }

    private static void sendPostRequest2(String host, String path, int port, String data) throws IOException {
        try(Socket socket = new Socket(host, port)){

            StringBuilder sb = new StringBuilder();
            sb.append("POST ").append(path).append(" HTTP/1.1").append(newline)
                    .append("Host: ").append(host).append(":").append(port).append(newline)
                    .append("Connection: close").append(newline)
                    .append("Accept: application/json").append(newline)
                    .append("Content-Type: application/json").append(newline)
                    .append("Content-Length: ").append(data.length()).append(newline)
                    .append(newline)
                    .append(data);

            socket.getOutputStream().write(sb.toString().getBytes(StandardCharsets.UTF_8));
            socket.getOutputStream().flush();

            printResponse(socket.getInputStream());
        }
   }

   private static void printResponse(InputStream inputStream) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
            System.out.println("________________________________________");
        }
   }
}
