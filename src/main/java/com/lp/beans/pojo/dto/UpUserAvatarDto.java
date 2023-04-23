package com.lp.beans.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpUserAvatarDto {
    private Integer uid;
    private String email;
}
