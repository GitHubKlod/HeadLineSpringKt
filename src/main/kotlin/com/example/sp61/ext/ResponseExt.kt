package com.example.sp61.ext

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.sp61.bean.common.PageResponseBean


//fun <T : Any> BaseMapper<T>.selectWrapperExt(page:Long, pageSize:Long, ktQueryWrapper: KtQueryWrapper<T>): PageResponseBean<T> {
//    return try {
//        val pageData = Page<T>(page,pageSize)
//        this.selectPage(pageData,ktQueryWrapper)
//        PageResponseBean(
//            total = pageData.total,
//            page = pageData.current,
//            pageSize = pageData.size,
//            data = pageData.records
//        )
//    }catch (e:Exception){
//        PageResponseBean(code = 500,msg = "内部发生错误 :" + e.message)
//    }
//
//}