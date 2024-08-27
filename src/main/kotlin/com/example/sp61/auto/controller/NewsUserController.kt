package com.example.sp61.auto.controller

import com.example.sp61.auto.mapper.NewsUserM
import com.example.sp61.auto.service.impl.NewsUserSI
import com.example.sp61.bean.NewsUserBean
import com.example.sp61.bean.TokenBean
import com.example.sp61.bean.common.ResponseBean
import com.example.sp61.ext.logE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("user")
class NewsUserController {

    @Autowired
    lateinit var newsUserSI: NewsUserSI

    @PostMapping("login")
    fun postLogin(userName:String="",userPwd:String=""):ResponseBean {

        return newsUserSI.login(userName,userPwd)

    }
    @PostMapping("register")
    fun postRegister(@RequestParam("userName") userName:String="",@RequestParam("userPwd") userPwd:String=""):ResponseBean {

        return newsUserSI.register(userName,userPwd)
    }

    @GetMapping("getUserInfo")
    fun getUserInfo(@RequestHeader token:String):ResponseBean{

        return newsUserSI.getUserInfo(token)

    }

}