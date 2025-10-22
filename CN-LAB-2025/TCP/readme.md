 
## 🧩 **Step-by-Step: Running TCP Client & Server in Eclipse**

### **1️⃣ Create a New Java Project**

1. Open **Eclipse IDE**.
2. Go to **File → New → Java Project**.
3. Name it (e.g., `SocketDemo`) → click **Finish**.

---

### **2️⃣ Create the Package**

1. Right-click on `src` → **New → Package**.
2. Name it `com.sock`.
   *(If you prefer no package, that’s fine too — just adjust your code accordingly.)*

---

### **3️⃣ Add the Two Classes**

1. Right-click on `com.sock` → **New → Class**.

   * Name it `TcpServer`
   * Paste the shortened server code:

   ```java
   import java.io.*; 
   import java.net.*; 
   import java.nio.file.*;

   class TcpServer {
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
   ```

2. Similarly, create another class named `TcpClient` and paste this:

   ```java
   import java.io.*; 
   import java.net.*; 
   import java.util.*;

   class TcpClient {
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
   ```

---

### **4️⃣ Add a Test File**

Place a simple text file in your project directory, e.g.:

```
SocketDemo/
 ├── src/
 │    └── com/sock/
 │         ├── TcpServer.java
 │         └── TcpClient.java
 └── test.txt
```

---

### **5️⃣ Run the Server**

1. Right-click `TcpServer.java` → **Run As → Java Application**.
2. You should see:

   ```
   Client connected. (will appear once client connects)
   ```

Leave this window running — **don’t stop it**.

---

### **6️⃣ Run the Client**

1. Open a **second console** in Eclipse (or go to **Run → Run Configurations → Common → Allocate console**).
2. Right-click `TcpClient.java` → **Run As → Java Application**.
3. Enter the file name when prompted (e.g. `test.txt`).

You’ll see:

```
Enter filename: test.txt
<file contents printed here>
```

---

### **7️⃣ Verify Communication**

* The **Server console** will display:

  ```
  Client connected.
  Requested: test.txt
  File sent successfully!
  ```
* The **Client console** shows the actual file content or the “not found” message.

---

### ⚠️ **Common Pitfalls**

| Issue                                   | Fix                                                                            |
| --------------------------------------- | ------------------------------------------------------------------------------ |
| `BindException: Address already in use` | Stop previous run (red square in console) or change port.                      |
| `FileNotFoundException`                 | Place file in **project root** (same level as `src`).                          |
| Client connects but no output           | Ensure port matches (6000 on both sides).                                      |
| Multiple console windows missing        | Use **Run → Run Configurations → Allocate console** to open multiple consoles. |

---

### RUN IN TERMINAL

If Eclipse gets slow or ports get stuck,
you can always run directly from terminal inside your project folder: 
Go to folder in system explorer and click on open terminal here and run the below commands:

```bash
javac TcpServer.java TcpClient.java
java TcpServer
# in another terminal
java TcpClient
```

---
 
