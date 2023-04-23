//UserInfoPo
package com.lp.beans.pojo.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoPo {
    private Integer uid;
    private String username;
    private String nickname;
    private String avatar;
    private String email;
    private Integer rid;
    private String rname;
    private String rnameZh;
    private Boolean communicationEnabled;
}
