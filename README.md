# Similarity Web Application
A user can view the frequency of a given word and any similar words in the target notebook entry.

RestFul Service uses following Technologies:  

* Spring-boot
* Swagger (OpenAPI v3)  

### Usage  

build:
```
mvn clean install
```

docker run : 
```
docker build -f Dockerfile -t similarity .  
docker run -p 8080:8080 similarity
```  

### Documentation
For swagger documentation; 
```
http://localhost:8080/documentation
```  

![image](https://user-images.githubusercontent.com/2255525/119507205-4e754c00-bd77-11eb-8e10-560bcca83b54.png)
