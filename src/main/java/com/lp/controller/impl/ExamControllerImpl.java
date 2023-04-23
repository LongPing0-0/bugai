package com.lp.controller.impl;

import com.lp.beans.entity.ExamEntity;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.controller.ExamController;
import com.lp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamControllerImpl implements ExamController {

    @Autowired
    private ExamService examService;
    /**
     * 用户查找试卷
     * @return
     */
    @GetMapping("/exam/all")
    @Override
    public Result searchExam() {
        List<ExamEntity> allExam = examService.getAllExam();
        return !ObjectUtils.isEmpty(allExam)?Result.success("获取题库成功！",allExam):Result.error("获取题库失败！");
    }

    /**
     * 学生查找题库 --看是否已经做过，做过的不查找
     * @return
     */
    @GetMapping("/exam/my")
    @Override
    public Result searchMyExam() {
        List<ExamEntity> myExam = examService.getMyExam();

        return !ObjectUtils.isEmpty(myExam)?Result.success("获取题库成功！",myExam):Result.error("获取题库失败！");
    }

    /**
     * 学生通过eid查找题库看
     * @param deIdVo
     * @return
     */
    @PostMapping("/exam/eid")
    @Override
    public Result searchMyExamByEid(@RequestBody DeIdVo deIdVo) {
        System.out.println("传入的值为："+deIdVo.getId());
        ExamEntity myExam = examService.getMyExamByEid(deIdVo);

        return !ObjectUtils.isEmpty(myExam)?Result.success("获取题库成功！",myExam):Result.error("获取题库失败！");
    }
}
