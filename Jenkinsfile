#!groovy

//@Library('krg-devops-library') _

library identifier: 'krg-devops-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://corenegocio@bitbucket.org/corporacionfavorita/krg-jenkins-pipeline-shared-lib.git'])


springBootServicePipeline {
    slackNotificationChannel = 'kng-ci'
    namespace = 'framework'
}