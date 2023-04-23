//updatePasswordDto
package com.lp.beans.pojo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordDto {
    //更新密码传输相关数据给userMapper
    private String email;       //email
    private Integer type;        //类型
    private String code;        //验证码
    private String password;    //更新密码
}
