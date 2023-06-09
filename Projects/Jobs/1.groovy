node {
    stage("Install Java") {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins_master', keyFileVariable: 'SSH_PRIVATE_KEY', usernameVariable: 'SSH_USER')]) {
    sh "ssh -o StrictHostKeyChecking=no -i $SSH_PRIVATE_KEY $SSH_USER@206.81.10.239 yum install java-11-openjdk -y"
}
        
    }
}