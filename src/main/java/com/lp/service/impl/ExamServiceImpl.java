package com.lp.service.impl;

import com.lp.beans.entity.ExamEntity;
import com.lp.beans.entity.UserEntity;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.mapper.ClassMapper;
import com.lp.mapper.ExamMapper;
import com.lp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ExamMapper examMapper;
    /**
     * 查找题库
     * @return
     */
    @Override
    public List<ExamEntity> getAllExam() {
        Integer id = null;
        try {
            id = classMapper.selectUserClass(
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        List<ExamEntity> examEntities = null;
        try {
           examEntities = examMapper.selectSingleChoice(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return examEntities;
    }

    /**
     * 学生查找题库 --看是否已经做过，做过的不查找
     * @return
     */
    @Override
    public List<ExamEntity> getMyExam() {
        System.out.println("学生查找题库");
        Integer id = null;
        try {
            id = classMapper.selectUserClass(
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查找班级失败");
            return null;
        }

        System.out.println("班级id："+id);
        List<ExamEntity> examEntities = null;
        try {
            examEntities = examMapper.selectMySingleChoice(id,
                    ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid()
                    );
        }catch (Exception e){
            System.out.println("查找考试信息失败！");
            e.printStackTrace();
            return null;
        }
        System.out.println("查找考试信息："+examEntities);
        return examEntities;
    }

    /**
     * 学生通过eid查找题库看
     * @param deIdVo
     * @return
     */
    @Override
    public ExamEntity getMyExamByEid(DeIdVo deIdVo) {

        ExamEntity examEntities = null;
        try {
            examEntities = examMapper.selectMySingleChoiceByEid(
                    deIdVo.getId()
            );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return examEntities;
    }
}
