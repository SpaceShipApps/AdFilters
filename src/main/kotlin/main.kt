import com.adblock.jobs.filters.UPDATE_AD_FILTERS
import com.adblock.jobs.filters.UpdateAdFiltersJob
import com.adblock.runJobs
import com.adblock.utils.logi


fun main(args: Array<String>) {

    args.forEach { logi("args", it) }

    val jobs = args.mapNotNull { jobName ->
        when (jobName) {
            UPDATE_AD_FILTERS -> UpdateAdFiltersJob()
            else -> null
        }
    }

    runJobs(jobs)
}