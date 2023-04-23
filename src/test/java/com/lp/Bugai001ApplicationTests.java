package com.lp;

import com.lp.beans.pojo.dto.AppUpdateDto;
import com.lp.beans.pojo.dto.CommentDto;
import com.lp.beans.pojo.dto.CommunicationAndCommentDto;
import com.lp.beans.pojo.dto.CommunicationDto;
import com.lp.beans.pojo.po.CommentFavorPo;
import com.lp.mapper.AppUpdateMapper;
import com.lp.mapper.CommunicationMapper;
import com.lp.utils.QqAvatarUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@SpringBootTest
class Bugai001ApplicationTests {
    @Autowired
    private QqAvatarUtil qqAvatarUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AppUpdateMapper appUpdateMapper;


@Autowired
private CommunicationMapper communicationMapper;
//    @Autowired
//    private ExamMapper examMapper;
//    @Autowired
//    private ClassMapper classMapper;
//
//    @Autowired
//    private UserMapper userMapper;



    @Test
    void contextLoads() {
//        String qqAvatar = qqAvatarUtil.getQQAvatar("15707408@qq.com");
//        System.out.println(qqAvatar);
//        AppUpdateDto appUpdateDto = appUpdateMapper.selectAppUpdate();
//        System.out.println(appUpdateDto);
//        CommentFavorPo commentFavorPo = communicationMapper.selectIsCommentFavor(1, 22);
//        System.out.println(ObjectUtils.isEmpty(commentFavorPo));
//        List<CommentDto> commentDtos = communicationMapper.selectCommentByCmid(2);
//        System.out.println(commentDtos);
//        List<CommunicationDto> communications = communicationMapper.selectCommunications(null);
//        System.out.println(communications);
//        获取单个圈子信息
//        List<CommunicationAndCommentDto> communicationAndCommentDtos = communicationMapper.selectCommunicationAndComment(null);
//        System.out.println(communicationAndCommentDtos);
//        String encodePassword = passwordEncoder.encode("123456");
//        System.out.println(encodePassword);
        //根据u和sigma获取[-4.0,4.0]之间的正态分布数据图c

//
//        double x = 4; //要计算概率密度函数和累积分布函数的值


//        List<Integer> fx = new ArrayList<>();
//        for(int i = -40; i <= 40; i++){
//            fx.add(i);
//        }
//        System.out.println(fx);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2 = new ArrayList<>();
//        list1.add(14);
//        list1.add(21);
//        list1.addAll(list2);
//        System.out.println(list1);

//        //根据u和sigma获取[-4.0,4.0]之间的正态分布数据图c
//        double mean = 0; //均值
//        double stdDev = 1; //标准差
//        NormalDistribution normalDistribution = new NormalDistribution(mean, stdDev);
//        double x = 4; //要计算概率密度函数和累积分布函数的值
//
//
//        List<Integer> fy = new ArrayList<>();
//        for(int i = 1; i <= 40; i++){
//            fy.add(
//                    i
//            );
//        }
//        System.out.println(fy);

//        System.out.println("CDF: " + cdf);
//        for (Double i = 0d; i <= 40d; i += 0.1d){
//            System.out.println("x: "+i * 0.1);
//            System.out.println(
//
//            );
//        }



//        for (int i = -40; i <= 40; i++){
//            System.out.println(i*0.1);
//        }


//        ExamEntity examEntity = examMapper.selectMySingleChoiceByEid(1);
//        System.out.println(examEntity);
//        List<ExamEntity> examEntities = examMapper.selectSingleChoice(1);
//        System.out.println(examEntities);
//        Integer integer = classMapper.selectClassNumber("111");
//        System.out.println(integer);
    }

//    @Test
//    void testInsertUser(){
//        //测试插入用户
//        UserDto user = new UserDto(null,"zhangsan","123","1233");
//        userMapper.insertUser(user);
//        System.out.println(user);
//    }
}
