package com.lp.service;

import com.lp.beans.entity.ClassEntity;
import com.lp.beans.pojo.vo.AlNameVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.beans.pojo.vo.InsertNameVo;


import java.util.List;

public interface ClassService {

    //添加班级
    Boolean addClass(InsertNameVo insertNameVo);

    //查找所有班级
    List<ClassEntity> getAllClass();

    //删除班级
    Boolean deleteClass(DeIdVo deIdVo);

    //修改班级名称
    Boolean alterClass(AlNameVo alNameVo);

    //学生加入班级
    Boolean addClassUser(InsertNameVo insertNameVo);

    //查找学生是否加入过班级
    Boolean searchUserClass();
}
