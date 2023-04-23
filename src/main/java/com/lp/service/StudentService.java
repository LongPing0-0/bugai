package com.lp.service;

import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.ConcatNoticeVo;


public interface StudentService {
    //查找所有学生信息
    RespPageDto getAllStudentInfo(ConcatNoticeVo concatNoticeVo);
}
