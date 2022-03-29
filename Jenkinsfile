node{
  stage('SCM Checkout'){
    git 'https://github.com/riyabhatia99/springboot-restapi.git'
  }
  stage('Compile-Package'){
    def mvnHome =  tool name: 'Maven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
      def dockerHome = tool name: 'Docker', type: 'dockerTool'
  stage('Build Docker Image'){
    sh "${dockerHome}/bin/docker build -t riya1798/comp-assessment:4.0 ."
  }
  stage('Push Docker Image'){
    withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerhubPwd')]) {
    sh "${dockerHome}/bin/docker login -u riya1798 -p ${dockerhubPwd}"
  }
        sh "${dockerHome}/bin/docker push riya1798/comp-assessment:4.0"
  } 
}
