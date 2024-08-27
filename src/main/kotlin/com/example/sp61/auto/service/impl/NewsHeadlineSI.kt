package com.example.sp61.auto.service.impl


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryWrapper
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.sp61.auto.mapper.NewsHeadlineM


import com.example.sp61.bean.NewsHeadlineBean

import com.example.sp61.bean.common.PageResponseBean
import com.example.sp61.bean.common.ResponseBean
import com.example.sp61.common.ResponseCode
import com.example.sp61.ext.JwtManage
import com.example.sp61.ext.formatter
import com.example.sp61.ext.selectPageWrapperExt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NewsHeadlineSI : ServiceImpl<NewsHeadlineM, NewsHeadlineBean>() {
    @Autowired
    lateinit var newsHeadlineM: NewsHeadlineM

    fun findByPage(page: Long, pageSize: Long, type: Int, key: String): PageResponseBean<NewsHeadlineBean> {

        //条件
        val queryWrapper1 = KtQueryWrapper(NewsHeadlineBean::class.java).apply {

            like(key.isNotBlank(), NewsHeadlineBean::title, key)
            eq(type != 0, NewsHeadlineBean::type, type)

        }

        //返回数据
        return newsHeadlineM.selectPageWrapperExt(page, pageSize, queryWrapper1)
    }

    /**
     * 获取头条详情
     */
    fun getNewsHeadlineDetail(id: Int): ResponseBean {
        val detail = newsHeadlineM.getNewsHeadlineDetail(id)

        val ktUpdateWrapper = KtUpdateWrapper(NewsHeadlineBean::class.java).apply {

            set(NewsHeadlineBean::pageViews, (detail["pageViews"] as Int) + 1)
            set(NewsHeadlineBean::version, (detail["version"] as Int) + 1)
            eq(NewsHeadlineBean::hId, id)

        }
        newsHeadlineM.update(ktUpdateWrapper)

        return ResponseBean.ok(detail)
    }

    /**
     * 发布头条
     */
    fun publishNewsHeadline(newsHeadlineBean: NewsHeadlineBean, token: String): ResponseBean {

        newsHeadlineBean.apply {
            createTime = System.currentTimeMillis().formatter()
            updateTime = System.currentTimeMillis().formatter()
            pageViews = 0
            publisher = JwtManage.getUserId(token)?.toInt() ?: 0
        }

        return if (newsHeadlineM.insert(newsHeadlineBean) == 0)
            ResponseBean.fail(ResponseCode.INTERNAL_SERVER_ERROR)
        else
            ResponseBean.ok()
    }

    /**
     * 修改头条
     */
    fun updateNewsHeadline(newsHeadlineBean: NewsHeadlineBean, token: String): ResponseBean {


        //乐观锁获取一下版本号然后设置到新数据更新
        val data = newsHeadlineM.selectOne(KtQueryWrapper(NewsHeadlineBean::class.java).apply {
            eq(NewsHeadlineBean::hId, newsHeadlineBean.hId)
        })?:return ResponseBean.fail(ResponseCode.FAIL,"头条不存在")
        if ((JwtManage.getUserId(token)?.toInt() ?: 0) != data.publisher) {
            return ResponseBean.fail(ResponseCode.FAIL, "您不是头条作者，无权修改")
        }

        newsHeadlineBean.apply {
            updateTime = System.currentTimeMillis().formatter()
            version = data.version
        }

        return if (newsHeadlineM.updateById(newsHeadlineBean) == 0)
            ResponseBean.fail(ResponseCode.INTERNAL_SERVER_ERROR)
        else
            ResponseBean.ok()
    }

    /**
     * 删除头条
     */
    fun deleteNewsHeadline(hId: String, token: String): ResponseBean {


        //乐观锁获取一下版本号然后设置到新数据更新
        val data = newsHeadlineM.selectOne(KtQueryWrapper(NewsHeadlineBean::class.java).apply {
            eq(NewsHeadlineBean::hId, hId)
        })?:return ResponseBean.fail(ResponseCode.FAIL,"头条不存在")
        if ((JwtManage.getUserId(token)?.toInt() ?: 0) != data.publisher) {
            return ResponseBean.fail(ResponseCode.FAIL, "您不是头条作者，无权修改")
        }

        return if (newsHeadlineM.deleteById(hId) == 0)
            ResponseBean.fail(ResponseCode.INTERNAL_SERVER_ERROR)
        else
            ResponseBean.ok()
    }

}