FROM ubuntu-jdk

MAINTAINER Mirjakhon Ulmasov "mirjahonulmasov@gmail.com"

ENV version=aws-db-usage

ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.cs00v50y2zqb.us-east-2.rds.amazonaws.com:5427/postgres

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
