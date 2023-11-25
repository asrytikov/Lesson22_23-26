package p4;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try{
            while (true){
                String str = in.readLine();
                if (str.equals("END"))break;
                System.out.println("ECHO: " + str);
                out.println(str);
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }
}
