//用户信息实体类
package com.lp.beans.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity {
    private Integer id;
    private Integer uid;
    private String email;
    private String nickName;
}
