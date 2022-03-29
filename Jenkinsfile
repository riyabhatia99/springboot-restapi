node{
  stage('SCM Checkout'){
    git 'https://github.com/riyabhatia99/springboot-restapi.git'
  }
  stage('Compile-Package'){
    def mvnHome =  tool name: 'Maven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
  stage('Build Docker Image'){
    echo "Build done"
  }
  stage('Push Docker Image'){
    echo "image pushed"
  } 
}
