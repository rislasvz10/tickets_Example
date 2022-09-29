pipeline {

    agent any

    tools {
        maven 'mvnLocal'
        jdk 'jdkLocal'
    }

    parameters {
         string(name: 'name', defaultValue: 'ticket', description: 'Nombre del aplicación en Openshift')
         string(name: 'service', defaultValue: 'ticket-api', description: 'Nombre de servicio')
         string(name: 'image', defaultValue: 'ticket-archetype', description: 'Nombre de la imagen')
//          string(name: 'tag', defaultValue: 'v1.0.0-beta', description: 'Tag de la imagen')
//          string(name: 'nexus', defaultValue: 'nexus-0.dev.openshift.multivaloresgf.local:18444', description: 'Url de Nexus')
//          string(name: 'openshift', defaultValue: 'https://console.preprod.multivaloresgf.local:8443', description: 'Url de la consola de Openshift')
//          string(name: 'project', defaultValue: 'esb-multiva', description: 'Nombre del proyecto en Openshift')
//          string(name: 'env', defaultValue: '/var/jenkins_development/enviroments/pre.env', description: 'Variables de entorno para el aplicación en Openshift')
    }

stages{
      stage('Test and Reporting'){
          steps {
              sh 'mvn clean install site -Pdevelopment_reporting'
          }
          post {
              success {
                  echo 'Now Archiving...'
                  archiveArtifacts artifacts: '**/target/*.jar'
              }
              always {
                  junit 'target/surefire-reports/*.xml'
              }
          }
      }

//       stage('Build Container') {
//          steps {
//             sh "docker build --force-rm --no-cache -t ${params.imagen}:${params.tag} ."
//             sh "docker images -a | grep '<none>' | awk '{print \$3}' | xargs docker rmi -f || true"
//           }
//        }
//
//       stage('Push Container') {
//         steps {
//               sh "docker tag ${params.imagen}:${params.tag} ${params.nexus}/${params.imagen}:${params.tag}"
//               sh "docker push ${params.nexus}/${params.imagen}:${params.tag}"
//         }
//       }
//
//       stage('Deploy Image') {
//         steps {
//             withCredentials([usernamePassword(credentialsId: 'openshift-teca-pre-multiva-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
//               sh "oc login -u ${USERNAME} -p ${PASSWORD} ${params.openshift}"
//               sh "oc project ${params.project}"
//               sh "oc delete all --selector app=${params.nombre} || true"
//               sh "oc new-app --name=${params.nombre} ${params.nexus}/${params.imagen}:${params.tag} --env-file=${params.env}"
//               sh "oc expose service ${params.nombre} --name=${params.service} --target-port=8080 --generator=\"service/v2\""
//               sh "oc expose svc/${params.service}"
//               sh "docker rmi --force ${params.nexus}/${params.imagen}:${params.tag}"
//               sh "docker rmi --force ${params.imagen}:${params.tag}"
//             }
//         }
//       }

    }
}