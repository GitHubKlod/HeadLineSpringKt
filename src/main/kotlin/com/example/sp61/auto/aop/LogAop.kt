package com.example.sp61.auto.aop

import com.example.sp61.ext.println
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component


@Aspect
@Component
class LogAop {


    @Before("execution(* com.example.sp61.auto.controller.UserController.addUser())")
    fun before(){
        "before执行".println()
    }
    @After("execution(* com.example.sp61.auto.controller.UserController.addUser())")
    fun end(){
        "end执行".println()
    }
}