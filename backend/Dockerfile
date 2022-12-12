# Dockerfile for sample service using embedded tomcat server

FROM centos:centos7
MAINTAINER ecs-sample

RUN yum install -y \
     wget tar iproute git

# openjdk-17のインストール
RUN mkdir /usr/lib/jvm
WORKDIR /usr/lib/jvm/
RUN wget https://download.java.net/java/GA/jdk17.0.1/2a2082e5a09d4267845be086888add4f/12/GPL/openjdk-17.0.1_linux-x64_bin.tar.gz
RUN tar xvfz openjdk-17.0.1_linux-x64_bin.tar.gz
RUN rm -f openjdk-17.0.1_linux-x64_bin.tar.gz
WORKDIR ~/

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo --no-check-certificate

RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo

RUN yum install -y apache-maven

# javaのバージョン設定
ENV JAVA_HOME /usr/lib/jvm/jdk-17.0.1/
RUN alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-17.0.1/bin/java 1
RUN alternatives --set java /usr/lib/jvm/jdk-17.0.1/bin/java

RUN git clone https://github.com/shooketani/ecs-sample.git /usr/local/ecs-sample

RUN mvn install -f /usr/local/ecs-sample/pom.xml

RUN cp /etc/localtime /etc/localtime.org

RUN ln -sf /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=production /usr/local/ecs-sample/backend/target/backend-0.0.1-SNAPSHOT.jar
