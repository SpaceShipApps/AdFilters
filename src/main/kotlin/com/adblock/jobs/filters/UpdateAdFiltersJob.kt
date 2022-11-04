package com.adblock.jobs.filters

import com.adblock.Job
import com.adblock.utils.logi

const val UPDATE_AD_FILTERS = "update-ad-filters"

private val FILTERS = mapOf(
    // Mobile Ads
    "ads" to "https://raw.githubusercontent.com/AdguardTeam/AdguardFilters/master/MobileFilter/sections/adservers.txt",
    // Mobile Tracking + Spyware
    "spyware" to "https://raw.githubusercontent.com/AdguardTeam/AdguardFilters/master/MobileFilter/sections/spyware.txt",
    // Adguard Apps
    "apps" to "https://github.com/AdguardTeam/AdguardFilters/raw/master/MobileFilter/sections/specific_app.txt",
    // Adguard DNS
    "dns" to "https://adguardteam.github.io/AdGuardSDNSFilter/Filters/filter.txt",
    // EasyPrivacy Specific
    "EasyPrivacySpecific" to "https://github.com/easylist/easylist/raw/master/easyprivacy/easyprivacy_specific.txt",
    // EasyPrivacy Third-Party
    "EasyPrivacy3rdParty" to "https://raw.githubusercontent.com/easylist/easylist/master/easyprivacy/easyprivacy_thirdparty.txt"
)

class UpdateAdFiltersJob : Job(UPDATE_AD_FILTERS) {
    override fun run() {
        logi("UpdateAdFiltersJob", "start")
        FILTERS.map { AdFilterWriter(it.key, it.value).write() }
        logi("UpdateAdFiltersJob", "end")
    }
}