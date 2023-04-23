package com.lp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.beans.entity.StudentInfoEntity;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.ConcatNoticeVo;
import com.lp.mapper.StudentMapper;
import com.lp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    /**
     * //查找所有学生信息
     * @return
     * @param concatNoticeVo
     */
    @Override
    public RespPageDto getAllStudentInfo(ConcatNoticeVo concatNoticeVo) {
        PageHelper.startPage(concatNoticeVo.getCurrentPage(),concatNoticeVo.getSize());
        List<StudentInfoEntity> students;

        try {
            System.out.println("获取学生用户信息：");
            System.out.println(concatNoticeVo.getSearchTitle());
            students = studentMapper.getAllStudentInfo(concatNoticeVo.getSearchTitle());
            System.out.println(students);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        PageInfo<StudentInfoEntity> studentInfoEntityPageInfo = new PageInfo<>(students);
        return new RespPageDto(studentInfoEntityPageInfo.getTotal(),studentInfoEntityPageInfo.getList());
    }
}
