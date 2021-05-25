FROM openjdk:11
ADD target/similarity.jar similarity.jar
ENTRYPOINT ["java","-jar","similarity.jar"]
