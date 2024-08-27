package com.example.sp61.auto.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.example.sp61.bean.NewsHeadlineBean
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface NewsHeadlineM:BaseMapper<NewsHeadlineBean> {

    @Select("""
        select h_id,title,article,type, h.version ,t_name typeName ,page_views pageViews
            ,create_time,publisher,nick_name author 
                    from news_headline h
                        left join news_type t on h.type = t.t_id
                                left join news_user u  on h.publisher = u.u_id
                                            where h_id = #{id}
    """)
    fun getNewsHeadlineDetail(id:Int):MutableMap<String,Any>

}