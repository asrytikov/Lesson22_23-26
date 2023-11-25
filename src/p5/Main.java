package p5;

import java.io.IOException;
import java.net.InetAddress;

public class Main {
    static final int MAX_THREAD = 40;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress address = InetAddress.getByName(null);
        while (true){
            if (ClientThread.threadCount() < MAX_THREAD) new ClientThread(address);
            Thread.currentThread().sleep(100);
        }
    }

}
