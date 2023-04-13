FROM openjdk:17
VOLUME /tmp
ADD ./target/admin-server-0.0.1-SNAPSHOT.jar admin-server.jar
ENTRYPOINT [ "java", "-jar", "/admin-server.jar" ]