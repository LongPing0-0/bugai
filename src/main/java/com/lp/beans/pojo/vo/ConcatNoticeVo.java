package com.lp.beans.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcatNoticeVo {
    private String searchTitle;
    private Integer currentPage;
    private Integer size;
}
