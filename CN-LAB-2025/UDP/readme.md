 
## INSTRUCTIONS:
 

Make sure you’ve:

* Installed **JDK (Java Development Kit)** → verify using:

  ```bash
  java -version
  ```
* Placed both files — `UdpClient.java` and `UdpServer.java` — inside a folder that matches their package:

  ```
  com/sock/UdpClient.java
  com/sock/UdpServer.java
  ```

Folder structure should look like this:

```
SocketProgram/
└── com/
    └── sock/
        ├── UdpClient.java
        └── UdpServer.java
```

---

##   Step-by-Step Commands

### **  Navigate to your project root**

```bash
cd /path/to/SocketProgram
```

### **  Compile both programs**

```bash
javac com/sock/*.java
```

This generates:

```
com/sock/UdpClient.class
com/sock/UdpServer.class
```

---

### **  Run the Server (Receiver)**

In **Terminal 1**:

```bash
java com.sock.UdpServer
```

You’ll see:

```
Receiver started...
Waiting for messages:
```

---

### **  Run the Client (Sender)**

In **Terminal 2** (same folder):

```bash
java com.sock.UdpClient
```

Output:

```
Sender started...
Enter message:
```

Now type any message — for example:

```
Hello from Client
```

Immediately, the **server terminal** will display:

```
Hello from Client
```

---
 

* If you get `Address already in use`, it means port `3000` is still bound. Kill the process:

  ```bash
  sudo lsof -i :3000
  sudo kill -9 <PID>
  ```
* Both must run **on the same machine** (localhost), or use your **LAN IP** instead of `127.0.0.1` for cross-device tests.
* UDP is **connectionless**, so there’s no session — just fire-and-forget datagrams.

 
