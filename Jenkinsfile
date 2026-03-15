pipeline {
    agent any

    stages {

        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t product-api .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker stop product-api-container || true'
                sh 'docker rm product-api-container || true'
                sh 'docker run -d --name product-api-container -p 8081:8080 product-api'
            }
        }

    }
}
