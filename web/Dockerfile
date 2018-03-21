FROM jboss/wildfly:12.0.0.Final

MAINTAINER "Fourit"

COPY target/web.war wildfly/standalone/deployments/

RUN wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]