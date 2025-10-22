import java.io.*; 
import java.net.*; 
import java.nio.file.*;

class TCPServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(6000);
             Socket s = ss.accept();
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

            System.out.println("Client connected.");
            String f = in.readUTF();
            System.out.println("Requested: " + f);

            try {
                String content = Files.readString(Paths.get(f));
                out.writeUTF(content);
                System.out.println("File sent successfully!");
            } catch (IOException e) {
                out.writeUTF("The requested file doesn't exist!");
            }
        }
    }
}
