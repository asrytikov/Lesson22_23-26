import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        if (args.length != 1){
            System.err.println("Usage 1 mashine");
            System.exit(1);
        }

        InetAddress[] address = InetAddress.getAllByName(args[0]);
        for(InetAddress addr: address){
            System.out.println(addr);
        }

        /*DESKTOP-V6C7K7S/192.168.50.1
        DESKTOP-V6C7K7S/192.168.56.1
        DESKTOP-V6C7K7S/192.168.188.1
        DESKTOP-V6C7K7S/192.168.79.1
        DESKTOP-V6C7K7S/192.168.88.34
        DESKTOP-V6C7K7S/fe80:0:0:0:60e1:1c0d:110d:567f%31
        DESKTOP-V6C7K7S/fe80:0:0:0:b9fb:b2bb:4fd4:34dd%29*/

    }
}