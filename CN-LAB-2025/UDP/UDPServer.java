 

import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        System.out.println("Receiver started...\nWaiting for messages:");
        while (true) {
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
        }
    }
}
