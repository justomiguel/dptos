#!/bin/sh
# set the maven Opts for debugging
export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005" 
mvn jetty:run $@
