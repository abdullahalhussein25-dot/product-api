pipeline {
    agent any

    stages {

        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

    }
}
