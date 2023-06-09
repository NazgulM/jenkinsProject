properties([
    parameters([string(description: 'Enter the agent IP', name: 'IP', trim: true)])])

node {
    stage("Install Tree") {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins_master', keyFileVariable: 'SSH_PRIVATE_KEY', usernameVariable: 'SSH_USER')]) {
    sh "ssh -o StrictHostKeyChecking=no -i $SSH_PRIVATE_KEY $SSH_USER@$IP yum install tree -y"
}
        
    }
}