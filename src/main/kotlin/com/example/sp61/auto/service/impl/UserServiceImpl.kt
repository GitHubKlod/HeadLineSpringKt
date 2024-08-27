package com.example.sp61.auto.service.impl


import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.sp61.auto.mapper.UserMapper
import com.example.sp61.bean.common.PageResponseBean
import com.example.sp61.bean.User

import com.example.sp61.ext.selectPageWrapperExt

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : ServiceImpl<UserMapper,User>() {

//    @Autowired
//    lateinit var userDao: UserDaoImpl

//    @Autowired
//    lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    lateinit var userMapper : UserMapper

    override fun save(entity: User?): Boolean {
        return super.save(entity)
    }

    fun addUserService() {
        println("addUserService执行了")
//        jdbcTemplate.execute("insert into lx_db.user (uName, uAge) values ('KLOD3',18);")
        userMapper.addUser("KLOD4",19)
//        userMapper.insert(User(uName = "KLOD46", uAge = 19))
//        val userDao = UserDaoImpl()
//        userDao.addUser()
    }
    fun findAll(): PageResponseBean<User> {
//        val page = Page<User>(1,3)
//
//        userMapper.selectPage(page,null)
//        ("当前页:"+page.current+
//                "每页显示的条数:"+page.size+
//                "总记录数:"+page.total+
//                "总页数:"+page.pages+
//                "是否有上一页:"+page.hasPrevious()+
//                "是否有下一页:"+page.hasNext()).logE()
//        return userMapper.selectPageExt(1,4)
//        val queryWrapper = QueryWrapper<User>().apply {
////            eq("u_name","KLOD4")
//            like("u_name","KLOD")
//            between("u_age",33,77)
////            set("u_age",33)
//        }
        val queryWrapper1 = KtQueryWrapper(User::class.java).apply {
            like(User::uName,"KLOD")
            between(User::uAge,33,77)
        }

        return userMapper.selectPageWrapperExt(1,4,queryWrapper1)

    }
}