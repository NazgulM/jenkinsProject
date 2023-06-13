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


tfvars = '''
    ami_id = "ami-092b51d9008adea15"
    instance_type = "t2.micro"
    availability_zone = "us-east-2a"
    key_name = "my_mini"
'''

podTemplate(cloud: 'kubernetes', label: 'terraform', yaml: template) {
    node ('terraform') {
        container('terraform') {
            stage ('Clone repo') {
        git branch: 'main', url: 'https://github.com/NazgulM/jenkins-terraform.git'
    }

    withCredentials([usernamePassword(credentialsId: 'aws-creds', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
    stage('Init') {
        sh 'terraform init'
    }
    
    stage ('terraform apply') {
        writeFile file: 'hello.tfvars', text: tfvars
        sh 'terraform apply -var-file hello.tfvars --auto-approve'
    }
}  
        }
}
}
