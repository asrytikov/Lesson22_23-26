package p4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(p2.Main.PORT);
        System.out.println("Server start");
        try{
            while (true){
                Socket s = socket.accept();
                try{
                    new ServerThread(s);
                }catch (IOException exception){
                    s.close();
                }
            }
        }finally {
            socket.close();
        }

    }
}
