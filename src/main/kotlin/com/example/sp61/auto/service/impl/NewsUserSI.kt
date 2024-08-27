package com.example.sp61.auto.service.impl

import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.sp61.auto.mapper.NewsUserM
import com.example.sp61.auto.service.NewsUserS
import com.example.sp61.bean.NewsUserBean
import com.example.sp61.bean.common.ResponseBean
import com.example.sp61.common.ResponseCode
import com.example.sp61.ext.JwtManage
import com.example.sp61.ext.calculateMD5
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping

@Service
class NewsUserSI : ServiceImpl<NewsUserM, NewsUserBean>(), NewsUserS {


    @Autowired
    lateinit var newsUserM: NewsUserM

    /**
     * 登录验证
     * 返回Token
     */
    override fun login(userName: String, password: String): ResponseBean {

        //具体操作
        when{
            userName.isBlank() -> return ResponseBean.fail(ResponseCode.USER_NOT_EXIST)
            password.isBlank() -> return ResponseBean.fail(ResponseCode.USER_PASSWORD_ERROR)
        }
        val ktQueryWrapper = KtQueryWrapper(NewsUserBean::class.java).apply {
            eq(NewsUserBean::userName, userName)
        }
        val oneData = newsUserM.selectOne(ktQueryWrapper)
            ?: return ResponseBean.fail(ResponseCode.USER_NOT_EXIST)

        return if (oneData.userPwd == password.calculateMD5()) {
            val jwtToken = JwtManage.createToken(oneData.uId!!)
            ResponseBean.ok(jwtToken)
        } else {
            ResponseBean.fail(ResponseCode.USER_PASSWORD_ERROR)
        }

    }

    /**
     * 注册账号
     * 返回成功
     */

    override fun register(userName: String, password: String): ResponseBean {

        //具体操作

        val ktQueryWrapper = KtQueryWrapper(NewsUserBean::class.java).apply {
            eq(NewsUserBean::userName, userName)
        }

        return if (newsUserM.selectOne(ktQueryWrapper) == null) {
            val raw = newsUserM.insert(
                NewsUserBean(
                    userName = userName,
                    userPwd = password.calculateMD5(),
                    nickName = userName
                )
            )
            if(raw == 0)
                ResponseBean.fail(ResponseCode.INTERNAL_SERVER_ERROR)
            else
                ResponseBean.ok("注册成功")
        } else {
            ResponseBean.fail(ResponseCode.USER_ALREADY_EXIST)
        }
    }

    /**
     *  获取用户信息
     */
    override fun getUserInfo(token:String): ResponseBean {

        if(JwtManage.isExpiration(token))
            return ResponseBean.fail(ResponseCode.UNAUTHORIZED)

        val userId = JwtManage.getUserId(token)

//        val ktQueryWrapper = KtQueryWrapper(NewsUserBean::class.java).apply {
//            select(NewsUserBean::uId, NewsUserBean::userName, NewsUserBean::nickName)
//            eq(NewsUserBean::uId, userId)
//        }
        return ResponseBean.ok(newsUserM.selectById(userId).apply { userPwd=null })

    }
}