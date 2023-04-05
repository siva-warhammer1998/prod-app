pipeline {
    agent any 

    stages {
        stage('Env Values') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "ae8c96e0-8a1b-489c-8e1c-c3149014e12c", usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                        sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                    }
                }
                echo "Running ${env.BUILD_ID} in ${env.JAVA_HOME}"
            }
        }

         stage('Build') {
            steps {
                script{
                    sh "docker build -t prod-app ."        
                }
                echo 'Build complete......'
            }

         }
         stage('Push') {
            steps {
                script{
                    sh "docker tag prod-app siva1998/prodapp:latest"
                    echo "tagged image"
                    sh "docker push siva1998/prodapp:latest"
                }
                echo 'Pushed to dockerhub....'
            }

         }      
    }
}
