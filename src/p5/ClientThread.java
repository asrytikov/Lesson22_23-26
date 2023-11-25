package p5;

import p2.Main;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private int id = counter++;
    private static int threadCount = 0;

    public static int threadCount(){
        return threadCount;
    }

    public ClientThread(InetAddress address) {
        System.out.println("Making client " + id);
        threadCount++;
        try{
           socket = new Socket(address, Main.PORT);
        }catch (IOException exception){
            System.err.println("ERROR");
        }

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            start();
        }catch (IOException exception){
            try{
                socket.close();
            }catch (IOException exception1){
                System.err.println("ERR Socket");
            }
        }
    }

    public void run(){
        try{
            for (int i = 0; i < 25; i++) {
                out.println("Client " +id + ": " + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        }catch (IOException exception){
            System.err.println("IO EXC");
        }finally {
            try{
                socket.close();
            }catch (IOException exception){
                exception.printStackTrace();
            }
            threadCount--;
        }
    }
}
