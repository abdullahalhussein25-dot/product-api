
      pipeline {
    agent any

    stages {

        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Clean Docker') {
            steps {
                sh 'docker stop product-api-container || true'
                sh 'docker rm product-api-container || true'
                sh 'docker rmi product-api || true'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build --no-cache -t product-api .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name product-api-container -p 8081:8080 product-api'
            }
        }

    }
} 
