package com.lp.beans.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcatCommentVo {
    private Integer currentPage; //当前页数
    private Integer size;        //页面大小
    private Integer id; //id号
}
