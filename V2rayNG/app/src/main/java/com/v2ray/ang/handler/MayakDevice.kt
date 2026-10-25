package com.v2ray.ang.handler

import android.annotation.SuppressLint
import android.os.Build
import android.provider.Settings
import com.v2ray.ang.AngApplication
import com.v2ray.ang.AppConfig
import com.v2ray.ang.util.JsonUtil
import com.v2ray.ang.util.LogUtil

/**
 * Маяк: заголовки устройства для панели Remnawave — как у Happ. Без них панель с включённым лимитом устройств
 * (HWID) не отдаёт подписку, а с ними устройство видно и удаляется в боте.
 */
object MayakDevice {
    @SuppressLint("HardwareIds") // ANDROID_ID — стабильный идентификатор приложения на этом устройстве, не IMEI
    private fun hwid(): String = try {
        Settings.Secure.getString(AngApplication.application.contentResolver, Settings.Secure.ANDROID_ID).orEmpty()
    } catch (e: Exception) {
        LogUtil.e(AppConfig.TAG, "Mayak: ANDROID_ID unavailable", e)
        ""
    }

    private fun ascii(value: String): String = value.filter { it.code in 0x20..0x7E }.trim()

    /** Заголовки подписки с данными устройства; заданные пользователем вручную — главнее. */
    fun withDeviceHeaders(requestHeaders: String?): String? {
        val id = hwid()
        if (id.isBlank()) return requestHeaders
        val headers = linkedMapOf(
            "x-hwid" to id,
            "x-device-os" to "Android",
            "x-ver-os" to ascii(Build.VERSION.RELEASE ?: ""),
            "x-device-model" to ascii("${Build.MANUFACTURER} ${Build.MODEL}"),
        )
        headers.putAll(JsonUtil.parseHeadersToMap(requestHeaders))
        return JsonUtil.toJson(headers)
    }
}
