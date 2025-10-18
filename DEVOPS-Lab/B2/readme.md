 

### **Steps to Build and Run the Docker Container**

1. **Set Up Your Workspace:**

   * Copy-paste the files into a new folder, which will serve as your current working directory (PWD) in VSCode.

2. **Compile the Java Program:**

   * Open the terminal in VSCode.
   * Run the following command to compile the `sample.java` file:

     ```bash
     javac sample.java
     ```

3. **Run the Java Program:**

   * To execute the compiled Java program, run:

     ```bash
     java sample
     ```

4. **Build the Docker Image:**

   * In the terminal, run the following command to build your Docker image:

     ```bash
     docker build -t abc2-image .
     ```

5. **Run the Docker Container:**

   * Now, you’ll run two instances of the container (each exposed to different ports). You can run them one at a time:

     ```bash
     docker run -d --name c2 -p 8080:80 abc2-image:1.2
     docker run -d --name c2 -p 8082:80 abc2-image:1.2
     ```

     **Note:** You can technically run just one instance of the container. Running two on different ports might not be necessary unless you have specific reasons for doing so.

6. **Tag the Docker Image:**

   * Tag your Docker image to prepare it for pushing to DockerHub:

     ```bash
     docker tag <image-sha1> <dockerhub-username>/<image-id>:latest
     ```

     Replace `<image-sha1>` with your image’s SHA1 hash, and `<dockerhub-username>/<image-id>` with your DockerHub username and desired image ID.

7. **Push the Docker Image:**

   * Push the tagged Docker image to DockerHub:

     ```bash
     docker push docker.io/<username>/<image-id>:latest
     ```

---

8. **Pull the Docker Image:**

    

     ```bash
     docker pull docker.io/<username>/<image-id>:latest
     ```

---

By following these steps, you'll compile, build, and deploy and recheck with docker pull with your Dockerized application smoothly!

 
