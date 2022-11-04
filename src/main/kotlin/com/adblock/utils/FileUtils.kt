package com.adblock.utils

import java.io.File


private const val TAG = "FileUtils"

fun String.saveToData(fileName: String) {
    val file = getDataFile(fileName)
    if (!file.parentFile.exists()) {
        file.parentFile.mkdirs()
    }

    if (file.read()?.trim() == this.trim()) {
        logd(TAG, "$fileName is same content, skip.")
        return
    }

    file.bufferedWriter().use { it.write(this) }
}

fun File.save(text: String) {
    if (!parentFile.exists()) {
        parentFile.mkdirs()
    }

    if (read()?.trim() == text.trim()) {
        logd(TAG, "${this.name} is same content, skip.")
        return
    }

    bufferedWriter().use { it.write(text) }
}

fun File.read(): String? {
    if (!exists()) {
        return null
    }
    return readText()
}

fun getRootFile(fileName: String): File =
    File(getProjectDir(), fileName)

private fun getDataFile(fileName: String): File =
    File(getProjectDir() + if (isDebug) "/data_test" else "/data", fileName)