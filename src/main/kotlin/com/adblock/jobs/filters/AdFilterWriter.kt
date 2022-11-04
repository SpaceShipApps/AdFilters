package com.adblock.jobs.filters

import com.adblock.utils.*

private const val TAG = "AdFilterWriter"

class AdFilterWriter(
    private val name: String,
    private val url: String,
) {
    private var ignoreDomain = mutableListOf<String>()
    fun write() {
        safeRun {
            logi(TAG, "start $name: $url")
            val text = request(url).lines().map { it.parseLine() }
                .filter { it.isNotBlank() && (!ignoreDomain.contains(it)) }
                .joinToString("\n") { it }
            getRootFile("$name.txt").save(text)
            logi(TAG, "finish $name: $url")
        }
    }

    private fun String.parseLine(): String {
//        logi("xxx","from: $this")
        if (!contains(".")) {
            return ""
        }
        if (contains("*")) {
            return ""
        }
        if (contains("/")) {
            return ""
        }
        if (contains("=")) {
            return ""
        }
        if (contains("#")) {
            return ""
        }
        if (contains(" ")) {
            return ""
        }
        var line = this
        listOf(
            "||",
            "^",
            "\$third-party",
            ",third-party",
            "\$image",
            ",image",
            ",important",
            "\$script",
            ",script",
            ",object",
            "\$popup",
            "\$empty",
            "\$object-subrequest",
            "\$subdocument"
        ).forEach {
            line = line.replace(it, "")
        }

        if (line.contains("xmlhttprequest")) {
            return ""
        }
        if (line.contains("~")) {
            return ""
        }
        if (line.startsWith(".") || line.endsWith(".")) {
            return ""
        }
        if (line.startsWith("-")) {
            return ""
        }

        if (line.endsWith("|")) {
            line = line.replace("|", "")
        }
        if (line.contains("@@")) {
            ignoreDomain.add(line.replace("@@", ""))
            logi("ad filter", "ignore this:$this")
            return ""
        }

//        logi("xxx","to: $line")
        return line.trim().removeSuffix("^")
    }
}