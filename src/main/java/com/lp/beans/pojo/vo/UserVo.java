//UserVo
package com.lp.beans.pojo.vo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "zhangsan")
    private String username;
    @ApiModelProperty(name = "username",value = "密码",required = true,example = "zhangsan")
    private String password;
    @ApiModelProperty(name = "username",value = "邮箱",required = true,example = "zhangsan")
    private String email;
}
