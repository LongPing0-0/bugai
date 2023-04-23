package com.lp.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleChoiceEntity {
    private Integer id;
    private String title;
    private Integer type;
    private String answer;
    private String explain;
    private String userAnswer = "";
    private Boolean userFavor = false;
    private Boolean showAnswer = false;
    private List<OptionsEntity> optionList;
}
