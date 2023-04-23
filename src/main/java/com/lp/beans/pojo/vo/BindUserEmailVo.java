package com.lp.beans.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindUserEmailVo {
    private String email;       //email
    private String code;        //验证码
}
