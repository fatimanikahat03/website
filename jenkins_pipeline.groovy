pipeline {
     agent any
     stages {
      stage('Checkout') {
           agent { label 'test' }
         steps {
             git branch: 'master',url: 'https://github.com/fatimanikahat03/website.git'
         }
      }
      stage('Build image') {
        agent { label 'test' }
          steps {
            sh "docker build . -t nikahat/project2"
            sh "docker run -it -d -p 82:80 nikahat/project2"
         }
      }
      stage('Push image') {
         agent { label 'test' }
         steps {
            sh "docker push nikahat/project2"
         }
      }
      stage('Website test') {
              agent { label 'test' }
         steps {echo "testing is coming"
            
         }
      }
      stage('new image') {
              agent { label 'test' }
         steps {
            sh "docker rm -f \$(docker ps -q)"
            sh "docker rmi -f \$(docker images -q)"
         }
      }
      stage('kubernetes cluster') {
              agent { label 'test' }
             steps {
                 sh "systemctl daemon-reload"
                 sh "systemctl restart docker"
                 sh "sudo systemctl start kubelet"
            sh "kubectl apply -f deployment.yml"
         }}
          stage('Deploy to kubernetes cluster') {
             steps {
                  sh "systemctl daemon-reload"
                 sh "systemctl restart docker"
                 sh "sudo systemctl start kubelet"
          
            sh "kubectl apply -f service.yml"
         }}
      }
}
