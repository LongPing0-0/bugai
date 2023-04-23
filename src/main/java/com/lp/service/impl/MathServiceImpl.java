package com.lp.service.impl;

import com.lp.beans.pojo.vo.MathZTVo;
import com.lp.service.MathService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {


    /**
     * //根据u和sigma获取[-4.0,4.0]之间的正态分布数据图c
     * @param mathZTVo
     * @return
     */
    @Override
    public List<Double> getNormalDistribution(MathZTVo mathZTVo) {
        //根据u和sigma获取[-4.0,4.0]之间的正态分布数据图c
        double mean = mathZTVo.getU(); //均值
        double stdDev = mathZTVo.getSigma(); //标准差
        NormalDistribution normalDistribution = new NormalDistribution(mean, stdDev);
        double x = 4; //要计算概率密度函数和累积分布函数的值

//        List<Double> fy = new ArrayList<>();
//        List<Integer> fx = new ArrayList<>();
//        for(int i = -40; i <= 40; i++){
//            fx.add(i);
//            double density = normalDistribution.density(i);
//            fy.add(
//                    density
//            );
//        }\
        List<Double> fy = new ArrayList<>();
        for(double i = -4.0; i < 4.1; i += 0.1d){
            double density = normalDistribution.density(i);
            fy.add(
                    density
            );
        }
        return fy;
    }
}
