package com.example.sp61.auto.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.sp61.bean.NewsUserBean
import com.example.sp61.bean.common.ResponseBean
import org.springframework.stereotype.Repository

@Repository
interface NewsUserM:BaseMapper<NewsUserBean> {

//    fun login(userName:String,userPwd:String):ResponseBean

}