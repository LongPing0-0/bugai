package com.lp.beans.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcatCommunicationVo {
    private Integer currentPage; //当前页数
    private Integer size;        //页面大小
}
