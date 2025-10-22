 

import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sender started...\nEnter message:");
        while (true) {
            String msg = sc.nextLine();
            ds.send(new DatagramPacket(msg.getBytes(), msg.length(), ip, 3000));
        }
    }
}
