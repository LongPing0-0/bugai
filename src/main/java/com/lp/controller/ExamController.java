package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.DeIdVo;

public interface ExamController {
    //用户查找试卷
    Result searchExam();

    //学生查找题库 --看是否已经做过，做过的不查找
    Result searchMyExam();

    //学生通过eid查找题库看
    Result searchMyExamByEid(DeIdVo deIdVo);
}
