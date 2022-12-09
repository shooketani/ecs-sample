# Dockerfile for sample service using embedded tomcat server

FROM centos:centos7
MAINTAINER ecs-sample

RUN yum install -y \
    java-17-openjdk \
    java-17-openjdk-devel \
    wget tar iproute git

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo --no-check-certificate

RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo

RUN yum install -y apache-maven

ENV JAVA_HOME /etc/alternatives/jre

RUN git clone https://github.com/shooketani/ecs-sample.git /usr/local/ecs-sample

RUN mvn install -f /usr/local/ecs-sample/pom.xml

RUN cp /etc/localtime /etc/localtime.org

RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=production /usr/local/ecs-sample/backend/target/backend-0.0.1-SNAPSHOT.jar
