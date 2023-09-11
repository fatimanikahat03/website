FROM tomcat:8.0-alpine
LABEL "intellipaat project”
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY target/my.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
