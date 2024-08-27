package com.example.sp61.ext

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun String.calculateMD5():String{
    return try {
        // 获取 MessageDigest 实例
        val digest = MessageDigest.getInstance("MD5")
        // 将字符串转换为字节数组，并计算哈希值
        val hash = digest.digest(this.toByteArray(Charsets.UTF_8))
        // 将字节数组转换为十六进制字符串
        hash.joinToString("") { "%02x".format(it) }
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
        throw RuntimeException("MD5 algorithm not found", e)
    }
}