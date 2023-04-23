package com.lp.beans.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageDto {
    //总条数
    private Long total;
    //数据List
    private List<?> data;
}
