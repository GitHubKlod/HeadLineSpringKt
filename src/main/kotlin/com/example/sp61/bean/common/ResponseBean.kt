package com.example.sp61.bean.common

import com.example.sp61.common.ResponseCode
import java.io.Serializable

class ResponseBean(
    var code: Int = ResponseCode.SUCCESS.code,
    var msg: String = ResponseCode.SUCCESS.message,
    var data: Any? = null
) : Serializable {
    companion object {
        fun ok(
            data: Any? = null,
        ): ResponseBean {
            return ResponseBean(
                code = ResponseCode.SUCCESS.code,
                msg = ResponseCode.SUCCESS.message,
                data = data,
            )
        }
        fun fail(state:ResponseCode,message: String=""): ResponseBean {
            return ResponseBean(
                code = state.code,
                msg = state.message+message,
            )
        }
    }
}