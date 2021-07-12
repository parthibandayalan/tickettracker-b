FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/ttbackend.jar /opt/app
CMD ["java", "-jar", "/opt/app/ttbackend.jar"]