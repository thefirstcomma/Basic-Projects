import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws java.io.IOException {

        byte rec[] = new byte[4000];
        Scanner scan = new Scanner(System.in);

        DatagramSocket ds = new DatagramSocket();

        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        System.out.println("Client Started, type 'bye' to exit");

        while(true) {

            String input = scan.nextLine();

            buf = input.getBytes();

            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);

            ds.send(DpSend);

            if(input.equals("bye")) {
                break;
            }

            ds.setSoTimeout(3000);
            boolean continueSending = true;
            int counter = 0;

            DatagramPacket DpReceive = new DatagramPacket(rec, rec.length);

            while(continueSending && counter < 10) {
                counter++;

                try {

                    ds.receive(DpReceive);
                    continueSending = false;
                    String response = (data(rec) + " ");
                    System.out.println(response);

                } catch (SocketTimeoutException e) {

                    // no response in 3 seconds
                    System.out.println("No response in 3 secs");
                    System.out.println("Type 'bye' to exit");
                    break;

                }
            }

            

        }

    }

    public static StringBuilder data(byte[] a){

        if (a == null) 
            return null;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(a[i] != 0) {

            sb.append((char)a[i]);
            i++;
        }

        return sb;
    }

}
