
FROM amazoncorretto:17-alpine

ADD target/*.jar account.jar
ENTRYPOINT ["java", "-jar", "account.jar"]