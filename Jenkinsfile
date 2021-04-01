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
                withSonarQubeEnv('LocalSonar') {
                    sh 'mvn -X clean install sonar:sonar'
                }
            }
        }
        stage("Quality gate") {
            steps{
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}

// https://www.jenkins.io/doc/pipeline/steps/sonar/