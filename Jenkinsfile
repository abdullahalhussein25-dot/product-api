
      pipeline {
    agent any

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout Latest Code') {
            steps {
                checkout scm
                sh 'git branch'
                sh 'git rev-parse HEAD'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop product-api-container || true'
                sh 'docker rm product-api-container || true'
            }
        }

        stage('Remove Old Image') {
            steps {
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

    post {
        success {
            echo 'Deployment erfolgreich'
        }
        failure {
            echo 'Build oder Deployment fehlgeschlagen'
        }
    }
} 
