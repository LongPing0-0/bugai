//EmailCodeDto
package com.lp.beans.pojo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailCodeDto {
    private String email;   //email
    private String code;    //验证码
    private Integer type;    //类型 1注册   2找回密码
    private Timestamp end;  //过期时间
}
