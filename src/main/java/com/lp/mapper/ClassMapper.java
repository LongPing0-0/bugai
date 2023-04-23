package com.lp.mapper;

import com.lp.beans.entity.ClassEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {

    //查找是否存在该班级码
    Integer selectClassNumber(@Param("classNumber") String classNumber);
    //查找所有班级
    List<ClassEntity> selectAllClass(@Param("className") String className);

    //添加班级
    Integer insertClass(@Param("className") String className, @Param("classNumber") String classNumber);

    //删除班级
    Integer deleteClass(@Param("id") Integer id);

    //修改班级名称
    Integer updateClass(@Param("className") String className, @Param("id") Integer id);

    //通过classNumber查找id
    Integer selectClassById(@Param("classNumber") String classNumber);

    //学生通过班级号加入班级
    Integer insetUserClass(@Param("uid") Integer uid, @Param("cid") Integer cid);

    //查看学生是否已经加入过班级
    Integer selectUserClass(@Param("uid") Integer uid);
}
