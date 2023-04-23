package com.lp.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity {
    private Integer id;
    private String className;
    private String classNumber;
}
