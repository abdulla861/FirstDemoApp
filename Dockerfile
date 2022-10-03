FROM openjdk:11
EXPOSE 9090
ADD target/first-demo-app.war first-demo-app.war
ENTRYPOINT ["java","-jar","/first-demo-app.war"]