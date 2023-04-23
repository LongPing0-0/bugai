package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.ConcatNoticeVo;

public interface StudentController {

    //查找所有学生
    Result searchAllStudent(ConcatNoticeVo concatNoticeVo);
}
