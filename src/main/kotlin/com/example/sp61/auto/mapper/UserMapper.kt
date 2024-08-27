package com.example.sp61.auto.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.sp61.bean.User
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.Mapping
import java.io.Serializable

@Repository
interface UserMapper:BaseMapper<User>{


    fun getUserById(uId:String):User

    fun addUser(uName:String,uAge:Int)


}