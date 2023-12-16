1) Create an application on Go/Python that serve HTTP requests at the next routes:
•⁠  ⁠8080:/
•⁠  ⁠8080:/health
/ - returns local time in New-York, Berlin, Tokyo in HTML format
/health - return status code 200, in JSON format

2) Dockerize your app.

*** step 1+2: *** goto time-service folder

3) Provision your infra using Terraform:
•⁠  ⁠VPC
•⁠  ⁠Subnets
•⁠  ⁠SGs
•⁠  ⁠Routing tables
•⁠  ⁠EKS cluster
•⁠  ⁠ECR

*** step 3: *** goto infra/terraform folder

4) Create and deploy Helm3 chart for your application.

*** step 4: *** goto infra/helm/springbootapp folder

5) Ensure that you have an access to the application endpoint externally
6) Provide an external http link

*** step 5+6: ***

http://a30bd74f1d3d0424d982077ae04e4364-397579705.eu-west-1.elb.amazonaws.com:8080/


http://a30bd74f1d3d0424d982077ae04e4364-397579705.eu-west-1.elb.amazonaws.com:8080/health

7) Upload your code to the Github public repository and provide link to us (put your code to the app, terraform, helm folders accordingly)