package com.example.sp61.auto.service

import com.baomidou.mybatisplus.extension.service.IService
import com.example.sp61.bean.NewsUserBean
import com.example.sp61.bean.common.ResponseBean

interface NewsUserS :IService<NewsUserBean>{


    fun login(userName:String,password:String): ResponseBean

    fun register(userName: String, password: String): ResponseBean

    fun getUserInfo(token: String):ResponseBean
}