package com.lp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lp.beans.entity.ClassEntity;

import com.lp.beans.entity.UserEntity;
import com.lp.beans.pojo.dto.RespPageDto;
import com.lp.beans.pojo.vo.AlNameVo;
import com.lp.beans.pojo.vo.DeIdVo;
import com.lp.beans.pojo.vo.InsertNameVo;
import com.lp.mapper.ClassMapper;
import com.lp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    /**
     * 添加班级
     * @param insertNameVo
     * @return
     */
    @Override
    public Boolean addClass(InsertNameVo insertNameVo) {
        if (!ObjectUtils.isEmpty(insertNameVo) && insertNameVo.getName()!=null){
            String code = code();
            System.out.println("班级号："+code);
            Integer integer = classMapper.selectClassNumber(code);
            System.out.println(integer);
            while (integer !=null){
                System.out.println("查找班级号");
                code = code();
                System.out.println("班级号："+code);
                integer = classMapper.selectClassNumber(code);
                System.out.println(integer);
            }
            try {
                classMapper.insertClass(insertNameVo.getName(), code);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * 查找所有班级
     * @return
     */
    @Override
    public List<ClassEntity> getAllClass() {
        List<ClassEntity> classEntities;
        try {
            classEntities= classMapper.selectAllClass(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return classEntities;
    }

    /**
     * 删除班级
     * @param deIdVo
     * @return
     */
    @Override
    public Boolean deleteClass(DeIdVo deIdVo) {
        try {
            classMapper.deleteClass(deIdVo.getId());
        }catch (Exception e){
         e.printStackTrace();
         return false;
        }
        return true;
    }

    /**
     * 修改班级名称
     * @param alNameVo
     * @return
     */
    @Override
    public Boolean alterClass(AlNameVo alNameVo) {
        try {
            classMapper.updateClass(alNameVo.getName(), alNameVo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 学生加入班级
     * @param insertNameVo
     * @return
     */
    @Override
    public Boolean addClassUser(InsertNameVo insertNameVo) {
        Integer cid = null;
        if (!ObjectUtils.isEmpty(insertNameVo) && insertNameVo.getName()!=null){
            try {
                cid = classMapper.selectClassById(insertNameVo.getName());
                System.out.println("查找到的cid:"+cid);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("没找到cid");
                return false;
            }
        }
        if (cid != null){
            try {
                System.out.println("加入班级");
                classMapper.insetUserClass(
                        ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid()
                        ,cid);
            }catch (Exception e){
                System.out.println("加入班级失败！");
                e.printStackTrace();
                return false;
            }
            return true;
        }

        return false;
    }

    /**
     * 查找学生是否加入过班级
     * @return
     */
    @Override
    public Boolean searchUserClass() {
        Integer id = null;
        try {
            id = classMapper.selectUserClass(
                ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return id == null ? false:true;
    }

    private String code(){
        Set<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        while (set.size() < 4) {
            set.add(random.nextInt(10));
        }
        Iterator<Integer> iterator = set.iterator();
        String temp = "";
        while (iterator.hasNext()) {
            temp += iterator.next();
        }
        return temp;
    }
}
