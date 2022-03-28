node{
  stage('SCM Checkout'){
    git 'https://github.com/riyabhatia99/springboot-restapi.git'
  }
  stage('Compile-Package'){
    def mvnHome =  tool name: 'Maven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
  stage('Build Docker Image'){
    sh 'docker build -t riya1798/comp-assessment:1.0 .'
  }
  stage('Push Docker Image'){
    withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerhubPwd')]) {
    sh 'docker login -u riya1798 -p ${dockerhubPwd}'
  }
        sh 'docker push riya1798/comp-assessment:1.0'
  } 
}
