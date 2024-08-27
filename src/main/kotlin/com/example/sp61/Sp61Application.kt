package com.example.sp61


import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import com.example.sp61.interceptor.TokenInterceptor
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@MapperScan("com.example.sp61.auto.mapper")
@SpringBootApplication
class Sp61Application{
	@Bean
	fun plusInterceptor(): MybatisPlusInterceptor {
		val interceptor = MybatisPlusInterceptor()
		interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))//分页
		interceptor.addInnerInterceptor(OptimisticLockerInnerInterceptor())//乐观锁
		// 如果有mybatis配置文件, 设置路径

		// factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		return interceptor
	}

//	@Bean
//	fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
//		val converter = MappingJackson2HttpMessageConverter()
//		val mapper = ObjectMapper()
//		mapper.setDateFormat(SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
//		converter.setObjectMapper(mapper)
//		return converter
//	}


}

fun main(args: Array<String>) {
	runApplication<Sp61Application>(*args)
}

