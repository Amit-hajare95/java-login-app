FROM tomcat:9

LABEL maintainer="amit_95"

# Optional: clean default apps
RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/java-login-app.war /usr/local/tomcat/webapps/java-login-app.war

EXPOSE 8080

ENTRYPOINT ["catalina.sh", "run"]
