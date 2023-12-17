# Simple app to understand Cross-Origin Resource Sharing

## What is Cross-Origin Resource Sharing ?
     Read about it more on https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS

CORS can be easily understood by using this example

### prerequisite - You should have installed.
1. Java 21
2. maven 
3. node.js

### Set up
1.  clone the repository git@github.com:bhanuprakashyr/spring-boot-cors-demo.git
2.  cd spring-boot-cors-demo
3.  mvn clean install

### 1. Update resource hosted from the same domain
1. java -jar .\target\spring-boot-cors-demo-0.0.1-SNAPSHOT.jar
2. open your favorite browser and hit http://localhost:8080/SimpleWebsite.html
3. login using username : user , password : password 
4. Open the browser debug console and you will observe no errors
5. Stop the server Ctrl + c
## No Cors issues is observed

### 2. Update resource hosted from the different domain - cors enabled (website.allow.cors=false)
1. java -jar .\target\spring-boot-cors-demo-0.0.1-SNAPSHOT.jar --website.allow.cors=false
2. install node http-server https://www.npmjs.com/package/http-server
3. Let's try to host the same website from http-server on port 9090
4. http-server ./src/main/resources/private -p 9090
5. Open browser and hit http://localhost:9090/SimpleAnotherWebsite.html
6. Open the browser debug console and you will observe cors errors
7. Stop the spring boot java process

### 3. Update resource hosted from the different domain - cors allowed for domain 9090 (website.allow.cors=true)
1. java -jar .\target\spring-boot-cors-demo-0.0.1-SNAPSHOT.jar --website.allow.cors=true
2. http-server ./src/main/resources/private -p 9090
3. Open browser and hit http://localhost:9090/SimpleAnotherWebsite.html
4. Open the browser debug console and you will observe cors errors



    