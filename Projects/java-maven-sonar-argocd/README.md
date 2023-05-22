# Jenkins Pipeline for Java based application using Maven, SonarQube, Argo CD, Helm and Kubernetes

In this project I have to use 2 GitHib repositories for source code and manifests repo.
Jenkins pipeline is doing Continious Integration  -> Webhook -> Jenkins -> Maven - if yes -> SonarQube ->  Tests -> New Image pushed to DockerHub
Code stored in Git repo -> Jenkins is responsible to watching commits onto this repo, whenever the changes or PR commited,
Jenkins Pipeline has to be triggered.
There are a lot of ways how the Jenkins Pipeline can be notified, the most efficient way is to use webhook, whenever you are using
the webhook, instead of the Jenkins is watching the repo, the Git send the notifications to Jenkins, in GitHub setting you will have the options to set the webhook URL, can define for  which action webhook has to be triggered, you can say Webhook has to be triggered on Commit or Pull Request. Whenever the Developer has created the PR or Commit, Git  will send the notification to Jenkins (Orchestrator tool) and ask Jenkins to start trigger the pipeline. Without using the GitHub WebHooks, if you are pulling continiously, or doing periodic build triggers, Jenkins continiously try to send requests to Git and try to fetch the information. 
In this case you are making a lot of API calls to git, whereas when you are using the webhooks, it only sends notifications or triggers whenever the specific action is performed. 

For this purpose I use the Jenkinsfile, for perform set of actions, use Maven for build the application. Then use the Docker Agent,
when use the the Docker agent, we do not have to worry about the installation at all, build with agent, unit test will be run. 
After unit test, static code analysis are passed successfully, can go to the next stage. The Docker Agent is very lightweight, useful, with using the Agent you cannot worry about installation issues, whenevr you are using the tools, Docker Agent will help with operation.

After can use the Jenkins email notifications, AWS Email notifications. If Build success, can integrate SonarQube- security code scanning tools, verify what happened in previous stages. Does it have the errors or security vulnerabilities, can sen the notification, can proceed with docker image. 
This pipeline is send the image to Docker registry, or Container registry, it can be Docker Hub, query.io, Elastic Container Registry.

Once pushed the last stage of the CI pipeline, how CI and CD communicate with each other, after that for Cd people used Ansible playbooks or Shell scripts, which will deploy or push artifacts to Kubernetes or any other target platform. But this is not much scalable, ansible or shell scripts are not designed for Continious Delivery. 

You have to choose CD tool, best CD tool is GITOPS base tool, similar to Github you have to create the repo for manifests also.
Argo Image Updator od Shell Script, GitHub Actions -> it can monitor container registry -> directly update Git repo with new yaml files or helm charts, ARGO CD -> whenever there is the change in the repo, take the yaml files - as soon as the commit created GITOPS tools is sitting in the Kubernetes cluster, whenever there is volume, image Argo Cd is deploy to repo. 

Steps:
```
I have a Git repo -> our app source -> as soon as developer push PR to Git repo ->  using the webhook - > 
trigger declarative Jenkins pipelines -> Using Maven as build language  build stage -> if it's successfully here is perform build tests-> using static code analysis -> fast/dash tools where we veryfy app security -> if any othese steps failed -> sent email or slack notification -> Success -> create Docker Image -> as soon as Docker image creared -> push the i,age to Docker Hub/ ECR/quai.io

Inside the Kuberenetes cluster -> deployed Argo Image Updator and Argo Cd -> Kubernetes controller -> Argo Image Updator -cont. monitor container registry -> it will pick the image and update that image and push to another repository -image, helm charts, customize yaml files -> Argo Cd it take new images and deploys to Kubernetes cluster.
```
![project](pr.png)



