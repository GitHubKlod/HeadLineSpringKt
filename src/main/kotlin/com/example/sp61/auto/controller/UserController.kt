package com.example.sp61.auto.controller

import com.example.sp61.auto.service.impl.UserServiceImpl
import com.example.sp61.bean.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userServiceImpl : UserServiceImpl

//    @Value("\${spring.datasource.url}")
//    private  lateinit var userName:String

    @GetMapping("user")
    fun addUser():String{

//        "Controller方法执行了$userName".println()
        userServiceImpl.save(User(uName = "KLOD5", uAge = 19))
//        userServiceImpl.addUserService()


        return "ASDASD"

//        userServiceImpl.addUserService()
    }
    @GetMapping("findUser")
    fun findUser():Any{

//        "Controller方法执行了$userName".println()
//        userServiceImpl.findAll()
//        userServiceImpl.addUserService()

        return userServiceImpl.findAll()

//        userServiceImpl.addUserService()
    }

}