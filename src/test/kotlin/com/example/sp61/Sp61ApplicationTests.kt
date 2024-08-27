package com.example.sp61

import com.example.sp61.ext.JwtManage
import com.example.sp61.ext.calculateMD5
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class Sp61ApplicationTests {

    @Test
    fun contextLoads() {
//        //MD5测试
//        val input = "Hello, world!"
//        println(input.calculateMD5())


//        //生成 传入用户标识 //JWT测试
//        val token: String = JwtManage.createToken(1L)
//        println("token = $token")
//
//        //解析用户标识
//        val userId: Long = JwtManage.getUserId(token)?:0L
//        println("userId = $userId")
//
//        //校验是否到期! false 未到期 true到期
//        val expiration: Boolean = JwtManage.isExpiration(token)
//        println("expiration = $expiration")
    }

}
