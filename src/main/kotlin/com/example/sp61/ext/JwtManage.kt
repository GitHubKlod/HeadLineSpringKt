package com.example.sp61.ext

import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.util.*
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory


object JwtManage {


    //    @Value("\${jwt.token.tokenExpiration}")
    private const val TE: Long = Long.MAX_VALUE
    private val KEY = byteArrayOf(
        24, -13, -88, -78, -36, 38, 83, -63, -64, -18, -48, -26, -105, -63, 51, 11, 15, 70, 111, 34, 20, 71, -3, 112, -88, -41, 34, 88, 108, 74, 90, -94
    )

    //    @Value("\${jwt.token.tokenSignKey}")
//    private val tokenSignKey: SecretKey = Jwts.SIG.HS256.key().build()
    private val tokenSignKey: SecretKey = Keys.hmacShaKeyFor(KEY)
//    private val tokenSignKey: SecretKey = KeyGenerator.getInstance("fc25155+").generateKey()



    //生成token字符串
    fun createToken(userId: Long): String {

//        println("tokenExpiration = $TE")
//        println("tokenSignKey = $tokenSignKey")
        return Jwts.builder()
            .subject("KLOD")
//            .expiration(Date(System.currentTimeMillis() + TE * 1000 * 60)) //单位分钟
            .expiration(Date(TE)) //单位分钟
            .claim("userId", userId)
//            .signWith(SignatureAlgorithm.HS512, tokenSignKey)
            .signWith(tokenSignKey)
            .compact()
    }

    /**
    从token字符串获取userid
     *
     */
    fun getUserId(token: String): Long? {
        if (token.isBlank()) return null
        val claimsJws: Jws<Claims> =
            Jwts.parser().verifyWith(tokenSignKey).build().parseSignedClaims(token)
        val claims = claimsJws.payload
        return try {
            (claims["userId"] as Int).toLong()
        }catch (e:Exception){
            null
        }
    }


    /**
     *     判断token是否有效
     */
    fun isExpiration(token: String?): Boolean {
        return try {
            //没有过期，有效，返回false
            Jwts.parser()
                .verifyWith(tokenSignKey)
                .build()
//                .setSigningKey(tokenSignKey)
                .parseSignedClaims(token)
                .payload.expiration.before(Date())
        } catch (e: Exception) {
            //过期出现异常，返回true
            true
        }
    }

}