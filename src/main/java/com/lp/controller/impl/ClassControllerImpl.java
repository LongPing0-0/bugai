package com.lp.controller.impl;

import com.lp.beans.entity.ClassEntity;
import com.lp.beans.pojo.Result;
import com.lp.beans.pojo.vo.AlNameVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.beans.pojo.vo.InsertNameVo;
import com.lp.controller.ClassController;
import com.lp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassControllerImpl implements ClassController {

    @Autowired
    private ClassService classService;

    /**
     * 添加班级
     * @param insertNameVo
     * @return
     */
    @PostMapping("/class/add")
    @Override
    public Result addClass(@RequestBody InsertNameVo insertNameVo) {
        Boolean aBoolean = classService.addClass(insertNameVo);

        return aBoolean?Result.success("添加班级成功！"):Result.error("添加班级失败！");
    }

    /**
     * 查找所有班级
     * @param
     * @return
     */
    @PostMapping("/class/all")
    @Override
    public Result searchAllClass() {
        List<ClassEntity> allClass = classService.getAllClass();
        if (!ObjectUtils.isEmpty(allClass)){
            return Result.success("获取所有班级成功！",allClass);
        }
        return Result.error("获取所有班级失败！");
    }

    /**
     * 删除班级
     * @param deIdVo
     * @return
     */
    @PostMapping("/class/de")
    @Override
    public Result deClass(@RequestBody DeIdVo deIdVo) {
        Boolean aBoolean = classService.deleteClass(deIdVo);
        return aBoolean?Result.success("删除班级成功！"):Result.error("删除班级失败！");
    }

    /**
     * 修改班级
     * @param alNameVo
     * @return
     */
    @PostMapping("/class/al")
    @Override
    public Result alClass(@RequestBody AlNameVo alNameVo) {
        Boolean aBoolean = classService.alterClass(alNameVo);
        return aBoolean?Result.success("修改班级成功！"):Result.error("修改班级失败!");
    }

    /**
     * 学生加入班级
     *
     * @param insertNameVo@return
     */
    @PostMapping("/class/userClass")
    @Override
    public Result addUserClass(@RequestBody InsertNameVo insertNameVo) {
        Boolean aBoolean = classService.addClassUser(insertNameVo);
        return aBoolean?Result.success("加入成功！"):Result.error("加入失败！");
    }

    /**
     * 学生查找是否加入过班级
     * @return
     */
    @GetMapping("/class/is")
    @Override
    public Result searchIsClass() {
        Boolean aBoolean = classService.searchUserClass();
        return aBoolean?Result.error("该学生已经加入过班级"):Result.success("该学生未加入过班级");
    }
}
