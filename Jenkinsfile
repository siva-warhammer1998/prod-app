pipeline {
    agent any 

    environment {
        DOCKERHUB_COMMON_CREDS = credentials('dockerhub-common-creds')
    }
    stages {
        stage('Env Values') {
            steps {
                sh 'docker login -u ${env.DOCKERHUB_COMMON_CREDS_USR} -p ${env.DOCKERHUB_COMMON_CREDS_PSW}'
                echo 'Running ${env.BUILD_ID} in ${env.JAVA_HOME}'
            }
        }

         stage('Build') {
            steps {
                echo 'Build complete......'
            }

         }
         stage('Push') {
            steps {
                echo 'Pushed to dockerhub....'
            }

         }      
    }
}