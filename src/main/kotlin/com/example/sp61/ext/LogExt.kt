package com.example.sp61.ext

import com.example.sp61.log.LoggerManager


fun String.logE(){
    LoggerManager.logger.error(this)
}

fun Any.println(){
    println(this)
}