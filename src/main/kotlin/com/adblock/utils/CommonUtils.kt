package com.adblock.utils

import com.google.gson.GsonBuilder

fun safeRun(printLog: Boolean = true, block: () -> Unit) {
    try {
        block()
    } catch (e: Throwable) {
        if (printLog) {
            e.printStackTrace()
        }
    }
}

val isDebug: Boolean by lazy { !ClassLoader.getSystemResource("MainKt.class").toString().contains(".jar") }

fun getProjectDir(): String = System.getProperty("user.dir")

fun gson() = GsonBuilder().disableHtmlEscaping().create()