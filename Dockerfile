FROM openjdk:11
ADD target/similarity.jar similarity.jar
EXPOSE 8035
ENTRYPOINT ["java","-jar","similarity.jar"]
