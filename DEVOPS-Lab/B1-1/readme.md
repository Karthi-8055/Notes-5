 

### **Steps to Complete the Experiment:**

1. **Set Up Your Workspace:**

   * Copy and paste the `sample.java` file into a folder in VSCode. This folder will be your **current working directory (PWD)**.

2. **Compile the Java Program:**

   * Open the terminal in VSCode.
   * Run the following command to compile your Java file:

     ```bash
     javac sample.java
     ```

3. **Run the Java Program:**

   * After compilation, execute the program using:

     ```bash
     java sample
     ```

4. **Build the Docker Image:**

   * Now, build the Docker image by running:

     ```bash
     docker build -t abc1-image .
     ```

5. **Run the Image in Docker Desktop:**

   * Open **Docker Desktop**.
   * Find and run the image you just built (`abc1-image`).

---
 
