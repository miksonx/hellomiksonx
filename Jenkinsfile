node {

    checkout scm

    env.DOCKER_API_VERSION="1.23"
    
    sh "git rev-parse --short HEAD > commit-id"

    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "hello-miksonx"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"
    env.BUILDIMG=imageName

    stage "Build"
    
        sh "docker build -t ${imageName} -f applications/hello-miksonx/Dockerfile applications/hello-miksonx"
    
    stage "Push"

        sh "docker push ${imageName}"

    stage "Deploy"

        sh "sed 's#127.0.0.1:30400/hello-miksonx:latest#'$BUILDIMG'#' applications/hello-miksonx/k8s/deployment.yaml | kubectl apply -f -"
        sh "kubectl rollout status deployment/hello-miksonx"
}
