FROM openjdk:17
VOLUME /tmp
ADD ./target/transaction-0.0.1-SNAPSHOT.jar service-transaction.jar
ENTRYPOINT [ "java", "-jar", "/service-transaction.jar" ]