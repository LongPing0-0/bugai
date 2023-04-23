package com.lp.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoEntity {
    private Integer uid;
    private String username;
    private String nickname;
    private String email;
    private Integer rid;
    private String rname;
    private String rnameZh;
    private Integer cid;
    private String className;

}
