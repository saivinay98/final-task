base_path = "final-task"
job_path = "${base_path}"
folder("${base_path}")

pipelineJob(job_path) {
    description("This job create a new pipeline job which installs K8's in azure VM")
    logRotator {
        daysToKeep(30)
    }
    parameters {
        stringParam {
            name ('Install_K8s)
            defaultValue('')
            description('K8 to be installed')
            trim(true)
        }
    }
    definition {
        cps {
            script(readFileFromWorkspace("${job_path}/Jenkinsfile"))
            sandbox(false)
        }
    }
}
