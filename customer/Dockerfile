FROM openjdk:17
VOLUME /tmp
ADD ./target/customer-0.0.1-SNAPSHOT.jar service-customer.jar
ENTRYPOINT [ "java", "-jar", "/service-customer.jar" ]