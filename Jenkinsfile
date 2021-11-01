pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {  // Building jar: /Users/virender.singh/Desktop/dockerhub/slave/workspace/SELENIUM_DOCKER_BUILDER/target/selenium-docker-tests.jar
                docker { // mvn clean package -DskipTests
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps { // Running on Docker1 in /Users/virender.singh/Desktop/dockerhub/slave/workspace/SELENIUM_DOCKER_BUILDER
                script {
                	app = docker.build("virenderpannu/selenium-docker")
                }
            }
        }
        stage('Push Image') { 
            steps {      // docker tag virenderpannu/selenium-docker registry.hub.docker.com/virenderpannu/selenium-docker:latest
                script { // docker push registry.hub.docker.com/virenderpannu/selenium-docker:latest
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhubcredentials') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}