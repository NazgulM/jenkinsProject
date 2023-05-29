# Create a CI/CD pipeline for a simple web application Python Flask using Jenkins

Prerequisites:
1. Create Ubuntu 22.04 Virtual Machine
2. Install jenkins server and run it

```
Step 1 - Update the System
apt update -y
apt upgrade -y

After updating all the system packages, install other required dependencies using the following command.
apt install curl debian-archive-keyring lsb-release ca-certificates apt-transport-https software-properties-common -y

Step 2 - Install Java
Jenkins is a java based application. So, you will need to install Java on your server. You install it by just running the following command.
apt install openjdk-11-jdk-headless -y

java --version
openjdk 11.0.19 2023-04-18
OpenJDK Runtime Environment (build 11.0.19+7-post-Ubuntu-0ubuntu122.10.1)
OpenJDK 64-Bit Server VM (build 11.0.19+7-post-Ubuntu-0ubuntu122.10.1, mixed mode, sharing)

Step 3 - Install Jenkins
By default, the Jenkins package is not included in the Ubuntu repository. So you will need to add the Jenkins repository to APT.

First, download the Jenkins GPG key with the following command.
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | gpg --dearmor -o /usr/share/keyrings/jenkins.gpg

Next, add the Jenkins repository to APT with the following command.
sh -c 'echo deb [signed-by=/usr/share/keyrings/jenkins.gpg] http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'

Once the repository is added, you can update the repository cache with the following command.
apt update -y

Then, install the Jenkins package using the following command.
apt install jenkins -y

Step 4 - Manage Jenkins Service
By default, the Jenkins service is managed by systemd. You manage it easily using the systemctl command.

Let’s start the Jenkins service with the following command.
systemctl start jenkins

Then, enable the Jenkins service so that it will start at system reboot.
systemctl enable jenkins

Now verify the Jenkins status using the following command.
systemctl status jenkins
```

on webBrowser type IP:8080
![jenkins first page](jenkins1.png)

Step 2: Set up version control Initialize git repository locally by running 
```
git init 

Commit your code to the local repository.
Create new repository on GitHub or any other platform of your choice.
Once you have created the remote repository, add it as origin to your local repo:
git remote add origin <remote-repo-url>

Push your changes to the remote repo:
$ git push -u origin master
```

Step 3: Configure Jenkins
Install required plugins such as Git Plugin, Pipeline Plugin ,and Python Plugin.
In Jenkins dashboard perform following actions:
Click on New Item -> Enter name for project like 'flask-app' -> Select Pipeline from list.
In pipeline section select ‘Pipeline script from SCM’ option under definition dropdown menu.
Choose Git option from SCM dropdown.
Provide URL of GitHub Repo and credentials if needed.
Specify branch name where code is pushed (e.g., */master).
Add Script Path by specifying path where you will keep jenkinsfile (Jenkinsfile).

Then you should specify following values while configuring pipeline script:
Repository URL:
https://github.com/NazgulM/jenkinsProject.git
(assuming .git extension)
Branch specifier : */master (to always pick master branch)
Script Path: flask-app/Jenkinsfile

In test.py we are using the built-in unittest module in Python to define a test case called TestApp. We create a client object from our Flask application (app) in the setup method so that it can be used throughout each test.

We have defined one simple test method called test_homepage() which checks if the homepage returns HTTP status code 200 and "Hello, World!" message.
Finally at bottom we use conditional block ('if name == 'main'') which runs all declared tests whenever file is executed directly.
You can write additional unit tests based on application requirements/complexity. These unit-tests should be comprehensive enough to cover most scenarios within your flask-app while ensuring consistent behaviour across different environments or releases

requirements.txt
```
flask==1.1.2
sqlalchemy==0.9.*
marshmallow>=3.*
itsdangerous==2.0.1
werkzeug==2.0.3
```

```
pip install -r requirements.txt
```

