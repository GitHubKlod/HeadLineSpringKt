package com.example.sp61.auto.controller

import com.example.sp61.auto.service.impl.NewsTypeSI
import com.example.sp61.bean.common.ResponseBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("news")
@CrossOrigin
class NewsTypeController {

    @Autowired
    lateinit var newsTypeSI: NewsTypeSI

    @GetMapping("getNewsTypeList")
    fun getNewsTypeList():ResponseBean {
        return newsTypeSI.getNewsTypeList()
    }
    @GetMapping("getNewsType")
    fun getNewsType(id:Int):ResponseBean {

        return newsTypeSI.getNewsTypeById(id)
    }


}