properties([
    parameters([
        string(description: 'Enter your IP: ', name: 'IP', trim: true),
        string(description: 'Enter your IP1: ', name: 'IP', trim: true)
        ])])

node {
   stage('Install Java') {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master', keyFileVariable: 'SSH_PRIVATE_KEY', usernameVariable: 'SSH_USER')]) {
   sh "ssh -o StrictHostKeyChecking=no -i $SSH_PRIVATE_KEY $SSH_USER@${params.IP} sudo dnf install java-11-amazon-corretto -y"
   }
}
        
}


node {
   stage('Install GIT') {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master', keyFileVariable: 'SSH_PRIVATE_KEY', usernameVariable: 'SSH_USER')]) {
   sh "ssh -o StrictHostKeyChecking=no -i $SSH_PRIVATE_KEY $SSH_USER@${params.IP} sudo yum install git -y"
   }
}
        
}
