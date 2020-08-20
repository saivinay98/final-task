base_path = "final-task"
job_path = "${base_path}/task"
folder("${base_path}")

pipelineJob(job_path) {
    description("This job create a new pipeline job which installs K8's in azure VM")
    logRotator {
        daysToKeep(60)
    }
    definition {
        cps {
            script(readFileFromWorkspace("${job_path}/Jenkinsfile"))
            sandbox(false)
        }
    }
}
