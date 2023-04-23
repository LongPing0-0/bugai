//EmailCodePo
package com.lp.beans.pojo.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailCodePo {
    private Integer id;     //id
    private String email;   //email
    private String code;    //验证码
    private String type;    //类型
    private Timestamp end;  //过期时间
}
