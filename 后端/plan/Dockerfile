FROM hub.c.163.com/library/java:8-jre

ADD target/*.jar plan.jar

EXPOSE 8888

ENTRYPOINT exec java $JAVA_OPTS -jar plan.jar