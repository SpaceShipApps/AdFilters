package com.adblock

import com.adblock.utils.logi
import com.adblock.utils.safeRun

abstract class Job(
    open val jobName: String,
) {

    abstract fun run()
}

fun runJobs(jobs: List<Job>) {
    for (job in jobs) {
        safeRun {
            logi(job.jobName, "start")
            job.run()
            logi(job.jobName, "finish")
        }
    }
}

