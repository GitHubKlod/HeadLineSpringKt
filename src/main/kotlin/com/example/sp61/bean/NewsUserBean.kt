package com.example.sp61.bean

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
import com.baomidou.mybatisplus.annotation.TableName
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import org.apache.ibatis.annotations.Delete
import org.springframework.transaction.annotation.Transactional

@Transactional
@TableName("news_user")
data class NewsUserBean(
    @TableId
    var uId: Long? = null,
    var userName: String? = null,
    var userPwd: String? = null,
    var nickName: String? = null,

//    @TableLogic
    var isDeleted: Int? = null,
    var version: Int? = null,

    )
