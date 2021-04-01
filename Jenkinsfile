pipeline {
    agent any
    stages {
        stage('Clone sources') {
            steps {
                git url: 'https://github.com/samaad/spring-rest-app.git'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                 sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                }
            }
        }
        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    }
}

// https://www.jenkins.io/doc/pipeline/steps/sonar/