#!/bin/sh
mvn clean install
sh target/bin/webapp > tomcat.8334/out.log
