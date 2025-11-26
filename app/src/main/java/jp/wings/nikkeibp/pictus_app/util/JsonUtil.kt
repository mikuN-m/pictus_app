package jp.wings.nikkeibp.pictus_app.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonUtils {
    private val gson = Gson()

    // List<String> → JSON文字列
    fun listToJson(list: List<String>): String {
        return gson.toJson(list)
    }

    // JSON文字列 → List<String>
    fun jsonToList(json: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }
}
