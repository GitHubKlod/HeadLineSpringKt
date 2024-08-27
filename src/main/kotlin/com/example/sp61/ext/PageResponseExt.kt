package com.example.sp61.ext

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.sp61.bean.common.PageResponseBean
import com.example.sp61.common.ResponseCode


//fun <T> BaseMapper<T>.selectPageExt(page:Long,pageSize:Long): PageResponseBean<T> {
//    return try {
//        val pageData = Page<T>(page,pageSize)
//        this.selectPage(pageData,null)
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
fun <T : Any> BaseMapper<T>.selectPageWrapperExt(page:Long, pageSize:Long, ktQueryWrapper: KtQueryWrapper<T>): PageResponseBean<T> {
    return try {
        val pageData = Page<T>(page,pageSize)
        this.selectPage(pageData,ktQueryWrapper)
        PageResponseBean.ok(
            total = pageData.total,
            page = pageData.current,
            pageSize = pageData.size,
            data = pageData.records
        )
    }catch (e:Exception){
        PageResponseBean.fail(ResponseCode.INTERNAL_SERVER_ERROR,e.message?:"")
    }

}