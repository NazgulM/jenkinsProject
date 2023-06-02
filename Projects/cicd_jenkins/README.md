# Automated CI/CD with Jenkins

What is CI CD Pipeline?
CI means Continuous Integration and CD means Continuous Delivery and Continuous Deployment.

![cicd](cdid5.png)

About Jenkins
Jenkins is most popular automation server used for setting up development environment with Continuous Integration & Continuous Deployment (CI & CD) automation which covers development processes like building, testing, vulnerability analysis and deployment etc.

It provides a complete web-based platform which includes a web application, work agents, build tools, Cloud, source code management and so on.

It was originally developed with name Hudson on the work by Kohsuke Kawaguchi in Sun Microsystems which later acquired by Oracle and it becomes licensed. Later on, a fork of Hudson created named Jenkins as open source project.

Jenkins supports wide range of applications which are used while development, testing and deployment. Some of them are:

Build tools: Ant, Maven, Gradle
Test & Report tools: Junit, JaCoCo, Cobertura, SonarQube
OS & Platform: Windows, Linux, Mac, Docker, Kubernetes
SCM tools: Git, GitHub, BitBucket, Subversion
Cloud: Digital Ocean, AWS, Azure, OCI etc.

Let’s understand a Continuous Integration (CI) automation for a Java & Maven based project:

Java based project requires steps to be executed to perform as part of CI automation like: Code Checkout, Compile, Build, Test, Package, Publish artifacts.
These steps defined, must be executed sequentially at each time when code change happens
If any step fails, the sub-sequent steps will be aborted e.g. if compilation fails then build, test, package etc. will be aborted and reported to owner about compilation failure
These steps form a Job in Jenkins and whenever code change happen / required Job can be triggered to perform the steps. One execution of steps / Job trigger referred as a Build in Jenkins.

Apart from Job creation, there are several ancillary features are provided to support the Job management like:

User and access management to control the Jenkins and Jobs access
Folder and View creation to arrange Jobs
Build, Job Definition and execution history
Jenkins plugins to enhance capabilities of Jenkins
These Job purpose, scope, features and other capabilities depends upon the Plugins and its version. These Job have some common features like:

Job Name, Description, Display Name fields
Enable project-based security — It depends upon security strategy plugins
Discard old builds — Defines policy how to discard the old build e.g. discard build older than 5 days, keep data only for last 10 builds etc.
GitHub project — Configure GitHub for SCM purpose
This project is parameterized — Parameters can be defined which further used in Job build steps
Throttle builds — Define policy for throttle the builds e.g. parallel build can be trigger
Disable this project — Disable the project
Restrict where this project can be run — Define where build can be executed based upon labels which mapped with Node label
Quiet period — Define quite period in seconds
Retry Count — Retry count for SCM
Block build when upstream project is building — Block builds when upstream project is building
Block build when downstream project is building — Block builds when downstream project is building
Use custom workspace — Custom directory can be defined as workspace
Trigger builds remotely (e.g., from scripts) — It creates a link which can be used to trigger build
Build after other projects are built — It defines build dependency with other Job in Jenkins
Build periodically — Trigger build based upon expression like cron
Poll SCM — Define the polling of SCM to check for update which helps detecting changes at SCM and build can be triggered
Provide Configuration files — Profile configuration file
Generate Release Notes — A link with JIRA for release note
Apart from these common features, based-on Job type ‘Build’ and ‘Post Build Actions’ are available. There are many types of Job based upon the nature and usability of Job e.g.

Freestyle Project

This type can be used to create a free-style project and multiple build steps can be created by adding steps from UI from defined list of activities e.g. Execute Shellscript, Gradle, Ant, Maven, Windows Batch Command etc. It can be used for any type of project where steps can be defined with available execution steps.

Maven Project
Maven project is recommended for Java based project which uses Maven as build tool. In Maven based Job, there is provision to define pom.xml and build goals like clean, compile, test, package, install, deploy etc.

Pipeline Projects
This type of Job is based upon pipeline script (earlier known as workflow) which is used create complex pipeline using groovy sandbox. From 2016, this has been enabled by default from Jenkins for creating pipeline.

It supports two types of script structures based upon programming approach:

Scripted — It is based upon imperative programming model. It begins with node keywords and use groovy code and references for Jenkins pipeline. It does not need steps with the stages.
Declarative — It is based upon declarative programming model, where stages breaks down into steps and starts with pipeline keyword.
From ability and performance angle, there is no different only difference is way of writing. If there is question to choose approach, declarative must be preferred as it provides much declarative ways and option to add multiple steps.

Additionally, it supports two ways providing pipeline:

Provide pipeline code in Jenkins Job
Create and file named Jenkins and add pipeline code and commit in SCM
Multi-configuration Project
It is based upon freestyle project with additional features like ‘Configuration Matrix’ where user defined axis can be created.

Multibranch Pipeline

It is again based upon groovy based pipeline code. Additional feature is, it connects with SCM, get list of branches and run build on each branch based change detected.

Follow the steps given to setup Jenkins on local from ‘Setup Jenkins’ section.

Setup Jenkins
Jenkins binary and deployment file available in formats supported for a range of operating systems and platforms. Some or the deployable deliveries are:

Generic Java based Web Application Archive (WAR) — It can be run on any platform where compatible JRE is available
Ubuntu/Debian
CentOS/Fedora/RedHat
Windows
openSUSE
FreeBSD
Gentoo
macOS
OpenBSD
Cloud Versions e.g. Jenkins Azure, Jenkins AWS, Jenkins on GKE, Jenkins IBM Cloud, Jenkins on OCI, Jenkins One-Click on Civo Kubernetes, Jenkins Bitnami Image
All Jenkins deployments are very simple and easy to install. For testing purpose, let’s try generic Java based WAR file.


