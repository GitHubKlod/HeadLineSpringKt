package com.example.sp61.bean

import com.baomidou.mybatisplus.annotation.TableName
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import org.springframework.transaction.annotation.Transactional

@Transactional
@TableName("news_type")
data class NewsTypeBean(
    var tId: Int? = null,
    var tName: String? = null,

    var isDeleted: Int? = null,

    var version: Int? = null,

    )
