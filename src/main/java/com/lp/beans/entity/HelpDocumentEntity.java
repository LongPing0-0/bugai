package com.lp.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpDocumentEntity {
    private Integer id;
    private String title;
    private String content;
}
