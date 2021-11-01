pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {  
                docker { 
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps { 
                script {
                	app = docker.build("virenderpannu/selenium-docker")
                }
            }
        }
        stage('Push Image') { 
            steps {      
                script { 
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhubcredentials') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}