package com.lp.beans.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {
    @ApiModelProperty(name = "id",value = "菜单id")
    private Integer id;
    @ApiModelProperty(name = "url",value = "url")
    private String url;
    @ApiModelProperty(name ="path",value = "vueRouterPath")
    private String path;
    @ApiModelProperty(name = "component",value = "vueComponent")
    private String component;
    @ApiModelProperty(name = "name",value = "vueName")
    private String name;
    @ApiModelProperty(name = "iconCls",value = "vueIconCls")
    private String iconCls;
    //    private Boolean keepAlive;
//    private Boolean requireAuth;
//    private Integer parentId;
//    private Boolean enabled;
    @ApiModelProperty(name = "children",value = "子菜单")
    private List<MenuEntity> children;
}
