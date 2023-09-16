FROM Apache2 
LABEL "intellipaat project2”
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
ADD . /var/www/html

