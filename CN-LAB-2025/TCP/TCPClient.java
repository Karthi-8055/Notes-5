import java.io.*; 
import java.net.*; 
import java.util.*;

class TCPClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("127.0.0.1", 6000);
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
             DataInputStream in = new DataInputStream(s.getInputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter filename: ");
            out.writeUTF(sc.nextLine());

            String data = in.readUTF();
            System.out.println(data.isEmpty() ? "The file is empty!" : data);
        }
    }
}
