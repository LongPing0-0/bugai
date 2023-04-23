//SedEmailDto
package com.lp.beans.pojo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeedEmailDto {
    private String email;
    private Integer type; //类型 1注册   2找回密码
}
