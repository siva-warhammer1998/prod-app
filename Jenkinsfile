pipeline {
    agent any 

    environment {
        DOCKERHUB_COMMON_CREDS = credentials('dockerhub-common-creds')
    }
    stages {
        stage('Env Values') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_COMMON_CREDS}", usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        sh "docker login -u ${env.DOCKERHUB_USERNAME} -p ${env.DOCKERHUB_PASSWORD}"
                    }
                }
                echo "Running ${env.BUILD_ID} in ${env.JAVA_HOME}"
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
