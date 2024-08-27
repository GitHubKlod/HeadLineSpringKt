package com.example.sp61.bean.common

import com.example.sp61.common.ResponseCode

data class PageResponseBean<T>(
    var code: Int=ResponseCode.SUCCESS.code,
    var msg: String=ResponseCode.SUCCESS.message,
    var page: Long?=null,
    var pageSize: Long?=null,
    var total: Long?=null,
    var data: MutableList<T>?=null
){
    companion object{
        fun <Y> ok(data: MutableList<Y>,
                   page: Long,
                   pageSize: Long,
                   total: Long,
        ):PageResponseBean<Y>{
            return PageResponseBean(code = ResponseCode.SUCCESS.code,
                msg = ResponseCode.SUCCESS.message,
                data = data,
                page = page,
                pageSize = pageSize,
                total = total
            )
        }
        fun <Y> fail(state:ResponseCode,message: String=""): PageResponseBean<Y> {
            return PageResponseBean(
                code = state.code,
                msg = state.message+message,
            )
        }
    }
}
