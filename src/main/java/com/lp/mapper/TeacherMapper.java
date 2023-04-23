package com.lp.mapper;

import com.lp.beans.pojo.po.UserInfoPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    //查找所有老师信息
    List<UserInfoPo> getAllTeacherInfo();
}
