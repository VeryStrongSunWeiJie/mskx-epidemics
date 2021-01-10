package com.swj.Util;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.util.Calendar;
import java.util.Map;

/**
 * 生成token
 */
@Component
public class JwtUtil {
    /**
     * 过期时间60分钟
     */
    private static final long EXPIRE_TIME = 60 * 60 * 1000;
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "ALIBABA";


    /**
     * 生成签名60分钟后过期
     *
     * @return 加密的token
     */
    public static String sign(Map<String, String> map) {
        try {
            JWTCreator.Builder builder=JWT.create();
            map.forEach((k,v)->{
                builder.withClaim(k,v);
            });
            Calendar inst = Calendar.getInstance();
            inst.add(Calendar.MINUTE,15);
            builder.withExpiresAt(inst.getTime());
            //附带userName userId信息，生成签名
            return builder.sign(Algorithm.HMAC256(TOKEN_SECRET)).toString();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 验证token
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
    }

    /**
     * 获取token中的信息
     *
     * @param token 密钥
     * @return token中包含的用户名
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
    }
}
