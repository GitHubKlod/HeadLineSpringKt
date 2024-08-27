package com.example.sp61.auto.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.sp61.auto.mapper.NewsTypeM
import com.example.sp61.bean.NewsTypeBean
import com.example.sp61.bean.common.ResponseBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseBody

@Service
class NewsTypeSI : ServiceImpl<NewsTypeM, NewsTypeBean>() {


    @Autowired
    lateinit var newsTypeM: NewsTypeM

    fun getNewsTypeList(): ResponseBean {

        return ResponseBean.ok(newsTypeM.selectList(null))
    }

    fun getNewsTypeById(id: Int): ResponseBean {

        return ResponseBean.ok(newsTypeM.selectList(null))
    }


}