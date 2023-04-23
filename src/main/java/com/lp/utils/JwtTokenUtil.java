//JwtTokenUtil
package com.lp.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    //根据用户信息生成Jwt
    public String generateJwt(UserDetails userDetails){
        Map<String,Object> claims=  new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateJwt(claims);
    }
    //从JWT获取用户名
    public String getUserNameFromJwt(String Jwt){
        String username;
        try {
            Claims claims = getClaimsFromJwt(Jwt);
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
            return  username;
    }
    //从JWT获取荷载
    public Claims getClaimsFromJwt(String Jwt){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(Jwt)
                    .getBody();
        }catch (Exception e){
            claims = null;
        }
        return claims;
    }
    //通过荷载生成token
    private String generateJwt(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims) //设置荷载
                .setExpiration(generateExpiration())  //设置过期时间
                .signWith(SignatureAlgorithm.HS512,secret)  //设置加密方式
                .compact();
    }
    //生成过期时间
    private Date generateExpiration(){
        //JWT失效时间，当前时间+配置时间
        return new Date(System.currentTimeMillis()+expiration * 1000);
    }
    //判断JWT是否过期
    public boolean validateToken(String JWT,UserDetails userDetails){
        String username = getUserNameFromJwt(JWT);
        return username.equals(userDetails.getUsername()) && !isJWTExpired(JWT);
    }
    //判断JWT是否失效
    private boolean isJWTExpired(String JWT){
        Date expiredDate = getExpireDateFromJWT(JWT);
        return expiredDate.before(new Date());
    }
    //从JWT里获取失效时间
    private Date getExpireDateFromJWT(String JWT){
        Claims claims= getClaimsFromJwt(JWT);
        return claims.getExpiration();
    }
    //判断JWT是否可以刷新
    public boolean isCanRefresh(String JWT){
        return !isJWTExpired(JWT);
    }
    //刷新JWT
    public String refreshJWT(String JWT){
        Claims claims = getClaimsFromJwt(JWT);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateJwt(claims);
    }
}
