package com.lp.mapper;

import com.lp.beans.entity.StudentInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    //查找所有学生信息
    List<StudentInfoEntity> getAllStudentInfo(@Param("nickname") String nickname);
}
