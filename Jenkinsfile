pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/votre-user/votre-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Nouveau plugin Coverage
            recordCoverage(tools: [[parser: 'JACOCO']])

            // Publier les résultats des tests
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Build réussi avec succès!'
        }
        failure {
            echo 'Le build a échoué.'
        }
    }
}
