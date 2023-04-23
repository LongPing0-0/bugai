package com.lp.mapper;


import com.lp.beans.entity.ExamEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExamMapper {

    //查找单选题
    List<ExamEntity> selectSingleChoice(@Param("cid") Integer cid);

    //学生查找题库 --看是否已经做过，做过的不查找
    List<ExamEntity> selectMySingleChoice(@Param("cid") Integer cid, @Param("uid") Integer uid);

    //学生通过eid查找题库看
    ExamEntity selectMySingleChoiceByEid(@Param("eid") Integer eid);


    //学生查找自己提交的试卷
    List<ExamEntity> selectMySubmitChoice(@Param("cid") Integer cid, @Param("uid") Integer uid);

}
