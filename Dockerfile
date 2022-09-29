FROM nexus-0.dev.openshift.multivaloresgf.local:8088/jboss-eap-7/eap71-openshift
LABEL "Empresa developer@gmail.com"
COPY /target/*.war $JBOSS_HOME/standalone/deployments/multiva-app.war
USER root
RUN chown jboss:jboss $JBOSS_HOME/standalone/deployments/multiva-app.war
USER jboss