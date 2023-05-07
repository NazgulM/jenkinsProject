# jenkinsProject

## What is Jenkins?

Jenkins is an open source continuous integration/continuous delivery and deployment (CI/CD) automation software DevOps tool written in the Java programming language. It is used to implement CI/CD workflows, called pipelines.
Java needs to be installed to use jenkins.

```
Amazon Linux
sudo su
yum install java -y
rpm -qa | grep java

javapackages-filesystem-6.0.0-7.amzn2023.0.5.noarch
java-17-amazon-corretto-headless-17.0.7+7-1.amzn2023.1.x86_64
java-17-amazon-corretto-17.0.7+7-1.amzn2023.1.x86_64

uname -a
Linux ip-172-31-22-156.us-east-2.compute.internal 6.1.25-37.47.amzn2023.x86_64 #1 SMP PREEMPT_DYNAMIC Mon Apr 24 23:20:16 UTC 2023 x86_64 x86_64 x86_64 GNU/Linux

wget https://archives.jenkins-ci.org/redhat-stable/jenkins-2.387.3-1.1.noarch.rpm
rpm -ivh jenkins-2.387.3-1.1.noarch.rpm 

systemctl start jenkins 
systemctl status jenkins
```

CI/CD 
A continuous integration and continuous deployment (CI/CD) pipeline is a series of steps that must be performed in order to deliver a new version of software. CI/CD pipelines are a practice focused on improving software delivery throughout the software development life cycle via automation.

CI stands for Continuous Integration. This means that every time a developer pushes code changes to a shared repository, the changes are automatically built and tested to ensure they integrate correctly with the existing codebase.

CD stands for Continuous Deployment/Delivery. Continuous Deployment means that the code changes are automatically deployed to production if they pass all the tests. Continuous Delivery means that the code changes are automatically deployed to a staging environment for testing, and if they pass, they are deployed to production manually.

To implement CI/CD, you'll need to use tools such as a version control system (e.g., Git), a build system (e.g., Jenkins), and a deployment system (e.g., Kubernetes). Here are the basic steps:

Developers commit their code changes to a shared repository.
The CI server automatically pulls the changes and builds them into a deployable artifact (e.g., a Docker container).
The CI server runs automated tests (e.g., unit tests, integration tests) to ensure that the changes are working correctly.
If the tests pass, the CD server deploys the changes to the staging environment for further testing (if using Continuous Delivery).
If the changes pass all the tests, the CD server deploys them to production (if using Continuous Deployment).

By using CI/CD, developers can catch and fix issues earlier in the development process, reducing the risk of bugs and errors in production. It also helps to automate the deployment process, making it faster and more reliable.

## Create Job

### Freestyle Project

This job type is the default project type, the most flexible to configure

### Pipeline:

A pipeline is a way  of defining your entire build process using the code in the form of Jenkins file.

#### Multi-branch Pipeline

Extension of a Pipeline job.
