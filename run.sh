#!/bin/bash
sh apache-tomcat-9.0.0.M15/bin/catalina.sh stop
mvn clean install
sh apache-tomcat-9.0.0.M15/bin/catalina.sh start

