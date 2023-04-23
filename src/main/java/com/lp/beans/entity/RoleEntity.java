//角色实体类
package com.lp.beans.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    private Integer rid;
    private String rname;
    private String rnameZh;
}
