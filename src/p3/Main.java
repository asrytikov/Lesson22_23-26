package p3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName(null);
        System.out.println("addr= " + addr);
        Socket socket = new Socket(addr, p2.Main.PORT);
        try{
            System.out.println("socket=" + socket);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            for (int i = 0; i < 10; i++) {
                printWriter.println("Hello " + i);
                String str = reader.readLine();
                System.out.println(str);
            }
            printWriter.println("END");
        }finally {
            System.out.println("Close");
            socket.close();
        }
    }
}
