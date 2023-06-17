template = '''
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: packer
  name: packer
spec:
  containers:
  - command:
    - sleep
    - "3600"
    image: hashicorp/packer
    name: packer
    '''

def buildNumber = env.BUILD_NUMBER

properties([
    parameters([
        choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], name: 'region')
        ])
        ])
if (env.BRANCH_NAME == "main") {
    region = "us-east-1"
    key_pair = "my_mini"
}

else if (env.BRANCH_NAME == "qa") {
    region = "us-east-2"
    key_pair = "my_mini"
}

else if (env.BRANCH_NAME == "dev") {
    region = "us-west-1"
    key_pair = "my_mini"
}


podTemplate(cloud: 'kubernetes', label: 'packer', showRawYaml: false, yaml: template) {
    node("packer"){
        container("packer"){

        withCredentials([usernamePassword(credentialsId: 'aws-creds', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
            withEnv(["AWS_REGION=${params.region}"]) {
            
            stage("Git Clone"){
                git branch: 'main', url: 'https://github.com/NazgulM/jenkins-parker.git'
            }
            
            stage("Packer"){
                sh "packer build -var 'jenkins_build_number=${buildNumber}' packer.pkr.hcl"

                build job: 'terraform', parameters: [string(name: 'action', value: 'apply'), string(name: 'region', value: "${region}"), string(name: 'ami_name', value: "my-ami-${buildNumber}"), string(name: 'az', value: "${region}b"), string(name: 'key_pair', value: "${key_pair}")]
            }
            }
        }
        }
    }
}