### informal instructions


copy paste the files into a vscode folder which will be your PWD
open terminal
javac sample.java
java sample
docker build -t abc2-image .
docker run -d --name c2 -p 8080:80 abc2-image:1.2
docker run -d --name c2 -p 8082:80 abc2-image:1.2
// im still unsure why we ran the same instance twice at multiple port, i think it'll suffice with just any one of them 



docker tag <image-sha1> <dockerhub-username>/<image-id>:latest
docker push docker.io/<username>/<image-id>:latest
