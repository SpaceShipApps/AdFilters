package com.adblock.utils

import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.InetSocketAddress
import java.net.Proxy


fun request(url: String): String {
    val client = OkHttpClient.Builder().apply {
        if (isDebug) {
            proxy(Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.0.1", 7890)))
        }
    }.build()
    val response = client.newCall(
        Request.Builder()
            .url(url)
            .build()
    ).execute()
    return response.body?.string().orEmpty()
}