package com.example.sp61.interceptor

import com.example.sp61.bean.common.ResponseBean
import com.example.sp61.common.ResponseCode
import com.example.sp61.ext.JwtManage
import com.example.sp61.ext.toJson
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor


@Component
class TokenInterceptor :HandlerInterceptor {


    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        val token = request.getHeader("token")

        if(!JwtManage.isExpiration(token)){
            return true
        }

        response.contentType = "application/json;charset=UTF-8"
        response.writer.print(
            ResponseBean.fail(
                ResponseCode.UNAUTHORIZED
            ).toJson()
        )
        return false
    }

}