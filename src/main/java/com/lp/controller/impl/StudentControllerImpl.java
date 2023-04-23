package com.lp.controller.impl;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.ConcatNoticeVo;
import com.lp.controller.StudentController;
import com.lp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerImpl implements StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 查找所有学生
     * @param concatNoticeVo
     * @return
     */
    @PostMapping("/student/all")
    @Override
    public Result searchAllStudent(@RequestBody ConcatNoticeVo concatNoticeVo) {
        RespPageDto allStudentInfo = studentService.getAllStudentInfo(concatNoticeVo);
        if(!ObjectUtils.isEmpty(allStudentInfo)){
            return Result.success("获取所有学生成功！",allStudentInfo);
        }
        return Result.error("获取所有学生失败！");
    }
}
