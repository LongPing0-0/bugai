package com.lp.beans.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentFavorPo {
    private Integer id;
    private Integer uid;
    private Integer cmid;
    private Timestamp favorTime;
}
