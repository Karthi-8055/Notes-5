 
### **Steps to Complete the Experiment:**

1. **Set Up Your Workspace:**

   * Copy-paste the files into a folder in VSCode. This folder will be your **current working directory (PWD)**.

2. **Compile the Java Program:**

   * Open the terminal in VSCode.
   * Run the following command to compile your `sample.java` file:

     ```bash
     javac sample.java
     ```

3. **Run the Java Program:**

   * After compiling, run the program with:

     ```bash
     java sample
     ```

4. **Build the Docker Image:**

   * Now, build the Docker image by running:

     ```bash
     docker build -t abc2-image .
     ```

5. **Run the Docker Container:**

   * Here’s where you run two instances of the same image (on different ports):

     ```bash
     docker run -d --name c2 -p 8080:80 abc2-image:1.2
     docker run -d --name c2 -p 8082:80 abc2-image:1.2
     ```

     **Note:** You’re running the same image twice but on different ports (8080 and 8082). If you just want one instance, you can run the image on either port—it should work just fine.

6. **Run the Image in Docker Desktop:**

   * Go to **Docker Desktop** and run the image `abc2-image` that you built.

---

**End of Experiment!**  

 
