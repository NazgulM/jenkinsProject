template = '''
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: terraform
  name: terraform
spec:
  containers:
  - command:
    - sleep
    - "3600"
    image: hashicorp/terraform
    name: terraform
    '''


tfvars = """
    region = "${params.region}"
    ami_id = "${params.ami_id}"
    instance_type = "t2.micro"
    availability_zone = "${params.az}"
    key_name = ${params.key_pair}
"""

        
properties([
    parameters([
        choice(choices: ['apply', 'destroy'], description: 'pick the action', name: 'action'),
        choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], description: 'Pick the region', name: 'region'), 
        string(description: 'Enter ami_id: ', name: 'ami_id', trim: true), 
        string(description: 'Enter availability zone: ', name: 'az', trim: true), 
        string(description: 'Enter your key_pair: ', name: 'key_pair', trim: true)])])

podTemplate(cloud: 'kubernetes', label: 'terraform', yaml: template) {
    node ('terraform') {
        container('terraform') {
            stage ('Clone repo') {
        git branch: 'main', url: 'https://github.com/NazgulM/jenkins-terraform.git'
    }

    withCredentials([usernamePassword(credentialsId: 'aws-creds', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
    stage('Init') {
        sh "terraform init -backend-config='key=${params.region}/${params.az}/terraform.tfstate'"
    }
    
    if (params.action == "apply") {
    stage ('terraform apply') {
        writeFile file: 'hello.tfvars', text: tfvars
        sh 'terraform apply -var-file hello.tfvars --auto-approve'
    }
    }
    
    else {
    stage ('terraform destroy') {
        writeFile file: 'hello.tfvars', text: tfvars
        sh 'terraform destroy -var-file hello.tfvars --auto-approve'
    }
}  
    
        }
}
}
}