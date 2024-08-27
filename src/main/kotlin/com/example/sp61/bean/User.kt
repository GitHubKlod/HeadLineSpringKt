package com.example.sp61.bean

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.KeySequence
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.example.sp61.Sp61Application
import com.example.sp61.annotation.NoArg
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.apache.ibatis.annotations.AutomapConstructor
import org.hibernate.annotations.Generated
import org.hibernate.annotations.PartitionKey
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Primary
import org.springframework.transaction.annotation.Transactional
//@AutomapConstructor constructor
@Transactional
//@NoArg
//@Entity(name = "user")
data class User(

    @TableId(type = IdType.ASSIGN_UUID)//主键自动生成用雪花算法
//    @Id
//    @Generated
    var uId :String?=null,
//    @TableId(value = "u_name")
    var uName: String?=null,
//    @TableId(value = "u_age")
    var uAge: Int?=null,
    ) {

}
