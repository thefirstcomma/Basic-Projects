import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws java.io.IOException {

        Scanner scan = new Scanner(System.in);

        DatagramSocket ds = new DatagramSocket();

        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        while(true) {

            String inp = scan.nextLine();

            buf = inp.getBytes();

            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);

            ds.send(DpSend);

            if(inp.equals("bye")) {
                break;
            }
        }

    }

}
