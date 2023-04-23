//EmailVo
package com.lp.beans.pojo.vo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailVo {
    @ApiModelProperty(name = "email",value = "email",required = true,example = "15707408@qq.com")
    private String email;
}
