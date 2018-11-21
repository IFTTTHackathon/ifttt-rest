FROM tomcat:8.0

ADD ./src/ /usr/local/tomcat/webapps/ifttt/src/
ADD ./WebContent/ /usr/local/tomcat/webapps/ifttt/WebContent/
ADD ./pom.xml /usr/local/tomcat/webapps/ifttt/pom.xml