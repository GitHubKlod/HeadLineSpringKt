package com.example.sp61.ext

import com.google.gson.Gson

/**
 * Bean - > Json
 */
fun Any.toJson() :String
        = Gson().toJson(this)
/**
 * Json - > Bean
 */
fun <T> String.fromJson(bean: Class<T>): T
            = Gson().fromJson(this, bean)