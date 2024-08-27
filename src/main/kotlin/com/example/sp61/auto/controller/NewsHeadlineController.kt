package com.example.sp61.auto.controller

import com.example.sp61.auto.service.impl.NewsHeadlineSI
import com.example.sp61.bean.NewsHeadlineBean
import com.example.sp61.bean.common.PageResponseBean
import com.example.sp61.bean.common.ResponseBean
import com.example.sp61.ext.logE
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("news")
class NewsHeadlineController {

    @Autowired
    lateinit var newsHeadlineSi: NewsHeadlineSI


    @GetMapping("getNewsHeadline")
    fun getNewsHeadline(page:Long=1,pageSize:Long=10,type:Int=0,key:String=""):PageResponseBean<NewsHeadlineBean>{
        "ASDASDASDASD".logE()
        return  newsHeadlineSi.findByPage(page,pageSize,type,key)

    }

    @GetMapping("getNewsHeadlineDetail")
    fun getNewsHeadlineDetail(id:Int):ResponseBean{

        return newsHeadlineSi.getNewsHeadlineDetail(id)
    }


}