package p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Start: " + serverSocket);
        try{
            Socket socket = serverSocket.accept();
            try{
                System.out.println("Connect accept: " + socket);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())), true);
                while (true){
                    String str = reader.readLine();
                    if (str.equals("END")) break;
                    System.out.println("ECHO: " +str);
                    printWriter.println(str);
                }
            }finally {
                System.out.println("Close");
                socket.close();
            }
        }finally {
            System.out.println("Close ServerSocket");
            serverSocket.close();
        }
    }
}
