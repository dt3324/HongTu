package com.danny.hongtu.service.impl;

import com.danny.hongtu.application.MyRedisClient;
import com.danny.hongtu.exception.TokenException;
import com.danny.hongtu.security.JwtField;
import com.danny.hongtu.service.JwtService;
import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * @author admin
 */
@Service("jwtService")
public class JwtServiceImpl implements JwtService {

    @Resource
    private JwtField jwtField;

    @Autowired
    private MyRedisClient redisUtilNew;


    @Override
    public String createJWT(Map<String, Object> claims, long ttlMillis) throws Exception {
        // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成JWT的时间
        long currentTimeMillis = System.currentTimeMillis();
        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
//        Map<String, Object> claims = new HashMap<String, Object>();
//        claims.put("uid", userId);
//        claims.put("userName", policeNumber);
        // 生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        SecretKey key = generalKey();
        addJwtKey(claims.get("username").toString(), key);
       /* // 下面就是在为payload添加各种标准声明和私有声明了
        // 这里其实就是new一个JwtBuilder，设置jwt的body
        // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
        // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
        // iat: jwt的签发时间
        // sub(Subject)：代  表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
        // 设置签名使用的签名算法和签名使用的秘钥*/
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(claims.get("userId").toString())
                .setIssuedAt(new Date(currentTimeMillis))
                .setSubject(claims.get("username").toString())
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            // 设置过期时间
            long expTimeMillis = currentTimeMillis + ttlMillis;
            builder.setExpiration(new Date(expTimeMillis));
        }
        // 就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
        return builder.compact();
        // 打印了一哈哈确实是下面的这个样子
        // eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJEU1NGQVdEV0FEQVMuLi4iLCJzdWIiOiIiLCJ1c2VyX25hbWUiOiJhZG1pbiIsIm5pY2tfbmFtZSI6IkRBU0RBMTIxIiwiZXhwIjoxNTE3ODI4MDE4LCJpYXQiOjE1MTc4Mjc5NTgsImp0aSI6Imp3dCJ9.xjIvBbdPbEMBMurmwW6IzBkS3MPwicbqQa2Y5hjHSyo
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    @Override
    public SecretKey generalKey() {
        // 本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        String stringKey = jwtField.getJwtSecret();
        // 本地的密码解码[B@152f6e2
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> parseJWT(String jwt) {
        // 签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        try {
            // 得到DefaultJwtParser
            Claims claims = Jwts.parser()
                    // 设置签名的秘钥
                    .setSigningKey(key)
                    // 设置需要解析的jwt
                    .parseClaimsJws(jwt).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            throw new TokenException("token过期");
        } catch (UnsupportedJwtException e) {
            throw new TokenException("Token格式错误");
        } catch (MalformedJwtException e) {
            throw new TokenException("Token没有被正确构造");
        } catch (SignatureException e) {
            throw new TokenException("签名失败");
        } catch (IllegalArgumentException e) {
            throw new TokenException("非法参数异常");
        }
    }


    @Override
    public void addJwtKey(String policeNumber, SecretKey key) {
        if ("".equals(policeNumber)) {
            throw new RuntimeException("警号为空");
        }
        String jwtKey = "" + policeNumber;
        // 令牌生成
        redisUtilNew.set(jwtKey, key);
    }

    @Override
    public void deleteJwtKey(String policeNumber) {
        if ("".equals(policeNumber)) {
            throw new RuntimeException("警号为空");
        }
        String jwtKey = "" + policeNumber;
        redisUtilNew.remove(jwtKey);
    }


}
