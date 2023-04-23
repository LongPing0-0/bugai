package com.lp.service;

import com.lp.beans.pojo.vo.MathZTVo;

import java.util.List;

public interface MathService {

    //根据u和sigma获取[-4.0,4.0]之间的正态分布数据图c
    List<Double> getNormalDistribution(MathZTVo mathZTVo);
}
