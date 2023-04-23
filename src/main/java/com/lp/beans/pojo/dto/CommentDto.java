package com.lp.beans.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Integer id;
    private Integer uid;
    private String nickname;
    private String avatar;
    private Integer cmid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp commentTime;
    private String content;
}
