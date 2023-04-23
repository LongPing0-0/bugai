package com.lp.beans.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationDto {
    private Integer id;
    private Integer uid;
    private String nickname;
    private String avatar;
    private Boolean communicationEnabled;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp created;
    private Boolean enabled;
    private Integer favorCount;
    private Integer commentCount;
}
