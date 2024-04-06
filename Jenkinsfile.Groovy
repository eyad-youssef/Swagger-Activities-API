pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your Git repository
                git 'https://github.com/eyad-youssef/Swagger-Activities-API.git'
            }
        }

        stage('Build and Dependencies') {
            steps {
                // Set up Maven and install dependencies
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Execute REST Assured tests and generate Allure results
                bat 'mvn test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                // Generate Allure report from the test results
                bat 'allure generate target/allure-results --clean'
            }
        }

        stage('Publish Allure Report') {
            steps {
                // Publish Allure report to Jenkins
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Archive the test artifacts for future reference
                archiveArtifacts 'target/*.html'
            }
        }
    }

    post {
        always {
            // Clean up artifacts or perform any necessary cleanup steps
            deleteDir()
        }
    }
}