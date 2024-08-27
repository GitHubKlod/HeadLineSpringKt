package com.example.sp61.bean

import com.baomidou.mybatisplus.annotation.*
import jakarta.persistence.Column
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import org.springframework.transaction.annotation.Transactional
import java.io.Serializable
import javax.xml.crypto.Data

@Transactional
@TableName("news_headline")
data class NewsHeadlineBean(

    @TableId(type = IdType.ASSIGN_UUID)//主键自动生成用雪花算法
    var hId: String? = null,
    var title: String? = null,
    var article: String? = null,
    var createTime: String? = null,
    var updateTime: String? = null,
    var type: Int? = null,
    var publisher: Int? = null,
    var isDeleted: Int? = null,
    var pageViews: Int? = null,
    @Version
    var version: Int? = null,

    ):Serializable
