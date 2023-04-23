//RegisterUserVo
package com.lp.beans.pojo.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户注册类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserVo {
    private String username;    //用户名
    private String password;    //密码
    private String email;       //email
    private String code;        //验证码
}
