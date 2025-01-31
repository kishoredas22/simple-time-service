# Setting up Jenkins for Simple-Time-Service

## Repository
Repository URL: [Simple Time Service](https://github.com/yourusername/simple-time-service.git)

## Overview
This guide focuses on setting up Jenkins to automate the entire build and deployment process for the Simple Time Service application. Since everything is managed through the pipeline, no manual execution is required.

## Prerequisites
1. Install Jenkins on your server.
2. Install required plugins:
   - Pipeline
   - Kubernetes CLI
   - Docker Pipeline
   - Google Cloud SDK (deploying to GCP)
   - Terraform
3. Configure Jenkins credentials:
   - Docker Hub authentication
   - Kubernetes cluster access
   - Terraform
4. Ensure Jenkins has access to the Git repository.

## Setting Up Jenkins Pipeline

### 1. Add Credentials to Jenkins
Navigate to **Manage Jenkins > Manage Credentials** and add:
- Docker Hub login credentials
- Kubernetes cluster configuration
- Terraform authentication

### 2. Create a Jenkins Pipeline Job
1. Open Jenkins Dashboard
2. Click **New Item** > Select **Pipeline**
3. Under **Pipeline Definition**, select **Pipeline script from SCM**
4. Enter the repository URL: `https://github.com/yourusername/simple-time-service.git`
5. Set the script path to `Jenkinsfile`

### 3. Configure Webhooks for Automated Deployment
- Go to your GitHub repository settings
- Under **Webhooks**, add a new webhook with the Jenkins URL: `http://your-jenkins-server/github-webhook/`
- Select **Just the push event**

### 4. Triggering the Pipeline
- Any new commit to the repository will trigger the pipeline automatically.
- You can also manually start a build by clicking **Build Now** in Jenkins.

### 5. Monitoring Pipeline Execution
- Go to Jenkins dashboard and open your pipeline job.
- View console output for real-time logs.
- Ensure the pipeline completes successfully.

### 6. Verifying Deployment (Optional)
Since everything is managed via the pipeline, there's no need to manually check deployments. However, if needed, you can verify the deployment:
```sh
kubectl get pods
kubectl get svc
curl http://<EXTERNAL_IP>
```

## Cleanup (If Needed)
To remove Jenkins and its configurations:
```sh
kubectl delete deployment jenkins
kubectl delete svc jenkins
```
