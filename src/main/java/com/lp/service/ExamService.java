package com.lp.service;

import com.lp.beans.entity.ExamEntity;
import com.lp.beans.pojo.vo.DeIdVo;

import java.util.List;

public interface ExamService {
    //查找题库
    List<ExamEntity> getAllExam();

    //学生查找题库 --看是否已经做过，做过的不查找
    List<ExamEntity> getMyExam();

    //学生通过eid查找题库看
    ExamEntity getMyExamByEid(DeIdVo deIdVo);
}
