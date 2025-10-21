import java.util.*;

class LeakyBucket {
    static int bucketSize = 1000;
    static int outputRate = 100;

    static void sendPacket(int pktSize) {
        if (pktSize > bucketSize) {
            System.out.println("Bucket overflow!");
            return;
        }

        while (pktSize > outputRate) {
            System.out.println(outputRate + " bytes of packets sent...");
            pktSize -= outputRate;
        }

        System.out.println(pktSize + " bytes of packets sent...");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter packet " + i + " size: ");
                int pkt = sc.nextInt();
                sendPacket(pkt);
            }
        } else {
            System.out.println("No packets to send!");
        }

        sc.close();
    }
}
