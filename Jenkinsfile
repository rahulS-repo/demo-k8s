pipeline {
  agent any

  tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven "maven3"
    dockerTool "docker"
  }

  stages {
    stage('Git Checkout') {
      steps {
        checkout scmGit(branches: [
          [name: '*/main']
        ], extensions: [], userRemoteConfigs: [
          [url: 'https://github.com/rahulS-repo/demo-k8s.git']
        ])
      }

    }
    stage('Build Maven') {
      steps {
        sh "mvn clean install"
      }

    }

    stage('Build Docker Image') {
      steps {
        //"docker build -t sharma201718/currency-exchange-devops:$env.BUILD_TAG"
        script {
          dockerImage = docker.build("sharma201718/demo-k8s:${env.BUILD_NUMBER}")
        }

      }
    }

    stage('Push Docker Image') {
      steps {
        script {
          docker.withRegistry('https://index.docker.io/v1/', 'id-docker-cred') {
            dockerImage.push("${env.BUILD_NUMBER}")
            dockerImage.push('latest')
          }
        }
      }
    }

  }
}