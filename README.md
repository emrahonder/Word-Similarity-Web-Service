
# Similarity Web Application  
A user can view the frequency of a given word and any similar words in the target notebook entry.  
  
#### Restful Service uses following Technologies:    
  
* Spring Boot 2.5
* Swagger (OpenAPI v3) 
   
#### Front-end
* Spring Boot (Thymeleaf)
* Bootstrap
* JQuery
  
## Run   
build:  
```  
mvn clean install  
```  
  
docker run :   
```  
docker build -f Dockerfile -t similarity . 
docker run -p 8080:8080 similarity  
```   
## Usage  
### Swagger   
```  
http://localhost:8080/documentation  
```   
### Back-end
This service has three endpoints: 
```  
GET: http://localhost:8080/similarity  
```
returns similarity object which has frequency and similar words list.
```  
GET: http://localhost:8080/similarwords  
```  
returns just similar words list.
```  
GET: http://localhost:8080//frequency  
```
returns just frequency
### Front-end
```  
http://localhost:8080  
```
![image](https://user-images.githubusercontent.com/2255525/119507205-4e754c00-bd77-11eb-8e10-560bcca83b54.png)


## Further
I have spent to build this application appr. 3 hours. If I would have more time, , I would like to

 - instead of a monolitic application, divide these as BE and FE project and build FE project with Vue.JS etc.
 - add more validations in BE and FE projects
 - update logging mechanism to write to the file
