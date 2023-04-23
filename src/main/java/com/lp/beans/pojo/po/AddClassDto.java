package com.lp.beans.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddClassDto {
    private Integer id;
    private String className;
    private String classNumber;
}
