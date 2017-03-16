FROM java:8
EXPOSE 8080
ADD /target/CustomerDocker.jar CustomerDocker.jar
ENTRYPOINT ["java","-jar","CustomerDocker.jar"]