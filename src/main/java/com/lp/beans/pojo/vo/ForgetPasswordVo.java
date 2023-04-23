//ForgerPasswordVo
package com.lp.beans.pojo.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 忘记密码类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgetPasswordVo {
    private String email;   //email
    private String password; //password
    private String code;    //验证码
}
