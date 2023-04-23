package com.lp.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationEntity {
    private Integer id;
    private Integer uid;
    private String content;
    private Timestamp created;
    private Boolean enabled;
}
