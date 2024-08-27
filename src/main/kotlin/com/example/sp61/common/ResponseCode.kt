package com.example.sp61.common

enum class ResponseCode(val code: Int, val message: String) {
    SUCCESS(200 , "成功"),
    FAIL(400 , "发生错误，"),
    UNAUTHORIZED(401,"未授权的请求,TOKEN可能过期"),
    NOT_FOUND(404,"找不到对应资源"),
    REQUEST_TIMEOUT(408,"请求超时"),
    INTERNAL_SERVER_ERROR(500,"服务器内部出现问题"),
    USER_NOT_EXIST(1001,"用户不存在"),
    USER_ALREADY_EXIST(1002,"用户已存在"),
    USER_PASSWORD_ERROR(1003,"密码错误")

}