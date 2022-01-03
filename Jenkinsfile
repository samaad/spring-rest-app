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
                 sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar -X'
                }
            }
        }
        stage("Quality gate") {
            steps {
                sleep time: 30000, unit: 'MILLISECONDS'
                script{
                    timeout(time: 10, unit: 'MINUTES') {
                        def qg = waitForQualityGate abortPipeline: true
                        if (qg.status != 'OK') {
                            echo "Status: ${qg.status}"
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
//                 waitForQualityGate abortPipeline: true
            }
        }
    }
}

// https://www.jenkins.io/doc/pipeline/steps/sonar/
