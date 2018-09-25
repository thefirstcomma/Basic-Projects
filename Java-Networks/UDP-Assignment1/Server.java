import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

public class Server {

    public static void main(String[] args) throws java.io.IOException {

        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        DatagramPacket DpReceive = null;

        System.out.println("Server Started");

        while(true) {

            String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ").format(new java.util.Date());
            DpReceive = new DatagramPacket(receive, receive.length);

            ds.receive(DpReceive);

            String response = (timeStamp + "Server:-" + data(receive));
            System.out.println(response);

            byte[] ref = (response).getBytes();
            DatagramPacket out = new DatagramPacket(ref, ref.length, DpReceive.getAddress(), DpReceive.getPort());
            ds.send(out);

            if(data(receive).toString().equals("bye")) {

                System.out.println("Client sent bye");
                break;

            }

            receive = new byte[65535];
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
