package com.lp.beans.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BanUserCommunicationVo {
    private Integer uid;
    private Integer communicationEnabled;
}
