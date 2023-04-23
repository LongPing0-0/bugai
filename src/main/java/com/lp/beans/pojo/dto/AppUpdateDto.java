package com.lp.beans.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUpdateDto {
    private Integer id;
    private Integer versionCode;
    private String url;
    private String content;
    private Boolean enabled;
    private Integer type = 0;
}
