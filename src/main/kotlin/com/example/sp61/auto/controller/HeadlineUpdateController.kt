package com.example.sp61.auto.controller

import com.example.sp61.auto.service.impl.NewsHeadlineSI
import com.example.sp61.bean.NewsHeadlineBean
import com.example.sp61.bean.common.ResponseBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("headline")
class HeadlineUpdateController {

    @Autowired
    lateinit var newsHeadlineSi: NewsHeadlineSI

    @PostMapping("publishNewsHeadline")
    fun publishNewsHeadline(newsHeadlineBean: NewsHeadlineBean, @RequestHeader token:String): ResponseBean {

        return newsHeadlineSi.publishNewsHeadline(newsHeadlineBean,token)

    }
    @PostMapping("updateNewsHeadline")
    fun updateNewsHeadline(newsHeadlineBean: NewsHeadlineBean, @RequestHeader token:String): ResponseBean {

        return newsHeadlineSi.updateNewsHeadline(newsHeadlineBean,token)

    }
    @PostMapping("deleteNewsHeadline")
    fun deleteNewsHeadline(hId: String, @RequestHeader token:String): ResponseBean {

        return newsHeadlineSi.deleteNewsHeadline(hId,token)

    }

}