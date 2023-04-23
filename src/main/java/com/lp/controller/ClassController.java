package com.lp.controller;

import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.AlNameVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.beans.pojo.vo.InsertNameVo;

public interface ClassController {

    //添加班级
    Result addClass(InsertNameVo insertNameVo);
    //查找所有班级
    Result searchAllClass();

    //删除班级
    Result deClass(DeIdVo deIdVo);

    //修改班级
    Result alClass(AlNameVo alNameVo);

    //学生加入班级
    Result addUserClass(InsertNameVo insertNameVo);
    //学生查找是否加入过班级
    Result searchIsClass();
}
